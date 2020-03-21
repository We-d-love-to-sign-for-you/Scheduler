package org.wedlovetosignforyou;

import java.util.UUID;

public class RandomUUIDJitsiUrlService implements VideoCallUrlService {
    @Override
    public String createNewJitsiUrl() {
        return "https://meet.jit.si/" + UUID.randomUUID();
    }
}
