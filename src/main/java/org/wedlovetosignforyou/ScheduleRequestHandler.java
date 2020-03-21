package org.wedlovetosignforyou;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

public class ScheduleRequestHandler implements RequestHandler<ScheduleRequest, String> {

    private InterpreterRepository interpreterRepository = new DynamoDBInterpreterRepository();
    private VideoLinkService videoLinkService = new RandomUUIDJitsiVideoLinkService();


    @Override
    public String handleRequest(ScheduleRequest scheduleRequest, Context context) {
        List<Interpreter> interpreters = interpreterRepository.findAvailableInterpretersBySkillNameAndMinLevel(
                scheduleRequest.getSkillName(),
                scheduleRequest.getMinSkillLevel());

        if (!interpreters.isEmpty()) {
            String link = videoLinkService.createVideoLink();

            Interpreter interpreter = interpreters.get(0);
            interpreter.setAvailable(false);
            interpreter.setVideoLink(link);
            interpreterRepository.saveInterpreter(interpreter);

            return link;
        } else {
            return "";
        }
    }
}
