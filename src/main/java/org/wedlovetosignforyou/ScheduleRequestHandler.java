package org.wedlovetosignforyou;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ScheduleRequestHandler implements RequestHandler<ScheduleRequest, String> {

    private InterpreterRepository interpreterRepository = new DynamoDBInterpreterRepository();
    private VideoCallUrlService videoCallUrlService;


    @Override
    public String handleRequest(ScheduleRequest scheduleRequest, Context context) {
        interpreterRepository.findInterpretersBySkillName(scheduleRequest.getSkillName());
        return scheduleRequest.toString();
    }
}
