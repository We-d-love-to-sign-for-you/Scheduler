package org.wedlovetosignforyou;

import com.amazonaws.services.lambda.runtime.Context;

public class Scheduler {

    private InterpreterRepository interpreterRepository;
    private JitsiUrlService jitsiUrlService;

    public String schedule(String skillName, String minSkillLevel, Context context) {
        return jitsiUrlService.createNewJitsiUrl();
    }
}
