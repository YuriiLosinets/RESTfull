package com.test.test3.exception;


import com.test.test3.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by CMI-USER on 2/12/2016.
 */

@Provider
public class DataNotFoundExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "http://vk.com");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
