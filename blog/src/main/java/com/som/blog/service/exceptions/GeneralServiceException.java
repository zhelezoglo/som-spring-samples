package com.som.blog.service.exceptions;

/**
 * @author som
 */
public class GeneralServiceException extends RuntimeException {
    public GeneralServiceException(String message) {
        super(message);
    }
}
