package org.wedlovetosignforyou;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

public class ScheduleRequestHandler implements RequestHandler<ScheduleRequest, ScheduleResponse> {

    private InterpreterRepository interpreterRepository = new DynamoDBInterpreterRepository();
    private VideoLinkService videoLinkService = new RandomUUIDJitsiVideoLinkService();


    @Override
    public ScheduleResponse handleRequest(ScheduleRequest scheduleRequest, Context context) {
        List<Interpreter> interpreters = interpreterRepository.findAvailableInterpretersBySkillNameAndMinLevel(
                scheduleRequest.getSkillName(),
                scheduleRequest.getMinSkillLevel());

        ScheduleResponse response = new ScheduleResponse();
        if (!interpreters.isEmpty()) {
            String link = videoLinkService.createVideoLink();
            response.setLink(link);

            Interpreter interpreter = interpreters.get(0);
            interpreter.setAvailable(false);
            interpreter.setVideoLink(link);
            interpreterRepository.saveInterpreter(interpreter);
            response.setInterpreter(interpreter);
        }

        return response;
    }
}
