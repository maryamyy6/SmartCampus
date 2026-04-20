/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mapper;

import com.example.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author Maryam Yonis- w2117084 
 */

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {
    
    @Override
    public Response toResponse(Throwable exception) {
        // Log the exception for debugging
        exception.printStackTrace();
        
        ErrorMessage errorMessage = new ErrorMessage(
            "An unexpected internal server error occurred",
            500,
            "https://westminster.ac.uk/student-api-docs/errors#409"
        );
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(errorMessage)
            .build();
    }
}

