package com.test.test3.exception;

import com.test.test3.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by CMI-USER on 2/12/2016.
 */
public class GenericExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        ErrorMessage errorMessage = new ErrorMessage(throwable.getMessage(), 500, "http://vk.com");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }
}