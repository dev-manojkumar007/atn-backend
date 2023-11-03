package com.attention.atnbackend.exception;

/**
 * @author : manojkumarpanchal
 * @created : 03/11/23, Friday
 **/
public class IncidentOperationException extends RuntimeException {

    public IncidentOperationException() {}
    public IncidentOperationException(String message) {super(message);}
    public IncidentOperationException(String message, Throwable cause) {super(message, cause);}
}
