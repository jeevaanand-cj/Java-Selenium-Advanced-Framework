package com.gcit.exceptions;

/**
 * Runtime Exception occurs when the path given for json path is incorrect.
 * May 26, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0
 * @see com.gcit.constants.FrameWorkConstants
 */
@SuppressWarnings("serial")
public class JsonExceptions extends RuntimeException {

	/**
	 * Pass the message that needs to be appended to the stack-trace
	 * @param message Details about the exception or custom message
	 */
    public JsonExceptions(String message) {
        super(message);
    }
    /**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stack-trace or customized stack-trace
	 */
    public JsonExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
