package org.wedlovetosignforyou;

import java.util.UUID;

public class RandomUUIDJitsiVideoLinkService implements VideoLinkService {
    @Override
    public String createVideoLink() {
        return "https://meet.jit.si/" + UUID.randomUUID();
    }
}
