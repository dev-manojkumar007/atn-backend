package com.attention.atnbackend.exception;

/**
 * @author : manojkumarpanchal
 * @created : 04/11/23, Saturday
 **/
public class SuspiciousPlaceOperationException extends RuntimeException {

    public SuspiciousPlaceOperationException() {}
    public SuspiciousPlaceOperationException(String message) {super(message);}
    public SuspiciousPlaceOperationException(String message, Throwable cause) {super(message, cause);}
}
