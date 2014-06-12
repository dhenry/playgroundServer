package com.hackathon.playground;

import com.hackathon.playground.jaxrs.server.PlaygroundService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class PlaygroundApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public PlaygroundApplication() {
        singletons.add(new PlaygroundService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
