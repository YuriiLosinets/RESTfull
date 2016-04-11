package com.test.test3.exception;

import org.omg.SendingContext.RunTime;

/**
 * Created by CMI-USER on 2/12/2016.
 */
public class DataNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = -6328286661536343936L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
