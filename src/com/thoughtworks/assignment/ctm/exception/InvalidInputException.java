package com.thoughtworks.assignment.ctm.exception;

/**
 * InvalidInputException is Custom Exception to handle invalid inputs .
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class InvalidInputException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidInputException(String s) {
        super(s);
    }
}
