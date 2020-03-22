package org.wedlovetosignforyou;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

public class ScheduleRequestHandler implements RequestHandler<ScheduleRequest, Interpreter> {

    private InterpreterRepository interpreterRepository = new DynamoDBInterpreterRepository();
    private VideoLinkService videoLinkService = new RandomUUIDJitsiVideoLinkService();


    @Override
    public Interpreter handleRequest(ScheduleRequest scheduleRequest, Context context) {
        List<Interpreter> interpreters = interpreterRepository.findAvailableInterpretersBySkillNameAndMinLevel(
                scheduleRequest.getSkillName(),
                scheduleRequest.getMinSkillLevel());

        if (!interpreters.isEmpty()) {
            Interpreter interpreter = interpreters.get(0);
            interpreter.setAvailable(false);
            String link = videoLinkService.createVideoLink();
            interpreter.setVideoLink(link);
            interpreterRepository.saveInterpreter(interpreter);
            return  interpreter;
        }

        return null;
    }
}
