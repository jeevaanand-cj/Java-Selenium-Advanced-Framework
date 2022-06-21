package com.gcit.exceptions;

/**
 * Runtime Exception occurs when database connection not able to established or database connection timeout
 * May 26, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0
 * @see com.gcit.constants.FrameWorkConstants
 */
@SuppressWarnings("serial")
public class SQLConnectionException extends RuntimeException{

	/**
	 * Pass the message that needs to be appended to the stack-trace
	 * @param message Details about the exception or custom message
	 */
    public SQLConnectionException(String message){
        super(message);
    }
    /**
   	 * 
   	 * @param message Details about the exception or custom message
   	 * @param cause Pass the enriched stack-trace or customized stack-trace
   	 */
    public SQLConnectionException(String message, Throwable cause){
        super(message, cause);
    }
}
