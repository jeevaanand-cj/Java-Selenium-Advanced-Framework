package com.gcit.exceptions;

/**
 * Runtime Exception occurs when the usage of utils files
 * May 26, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.utils.DataBaseConnection;
 * @see com.gcit.utils.DataProviderUtils;
 * @see com.gcit.utils.DecodeUtils;
 * @see com.gcit.utils.DynamicXpathUtils;
 * @see com.gcit.utils.ELKRealTimeDashBoardUtils;
 * @see com.gcit.utils.JsonUtils;
 * @see com.gcit.utils.PropertyUtils;
 * @see com.gcit.utils.ScreenSHotUtils;
 */

@SuppressWarnings("serial")
public class UtilsExceptions extends RuntimeException{

	/**
	 * Pass the message that needs to be appended to the stack-trace
	 * @param message Details about the exception or custom message
	 */
    public UtilsExceptions(String message){
        super(message);
    }
    /**
   	 * 
   	 * @param message Details about the exception or custom message
   	 * @param cause Pass the enriched stack-trace or customized stack-trace
   	 */
    public UtilsExceptions(String message, Throwable cause){
        super(message, cause);
    }

}
