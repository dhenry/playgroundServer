package com.hackathon.playground.jaxrs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PlaygroundExceptionHandler implements ExceptionMapper<PlaygroundException> {

    @Override
    public Response toResponse(PlaygroundException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
