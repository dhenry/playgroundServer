package com.hackathon.playground.jaxrs.exception;

import java.io.Serializable;


public class PlaygroundException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;
    public PlaygroundException() {
        super();
    }
    public PlaygroundException(String msg)   {
        super(msg);
    }
    public PlaygroundException(String msg, Exception e)  {
        super(msg, e);
    }
}
