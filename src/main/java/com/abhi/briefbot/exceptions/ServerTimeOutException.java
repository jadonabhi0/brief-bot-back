/**
 * 
 */
package com.abhi.briefbot.exceptions;



/**
 * <p>The ServerTimeOutException class represents an exception that is thrown
 * when a server operation exceeds a specified time limit. This exception
 * indicates that the server was not able to complete the operation within
 * the defined time frame.
 *
 * Usage:
 * - Use this exception to handle scenarios where a server operation times out
 *   due to reasons such as unresponsive external services or heavy load.
 * - Catch this exception to implement specific error handling logic when a
 *   server operation does not complete within the expected time.
 *
 * Example:
 * ```
 * try {
 *     performLengthyOperation();
 * } catch (ServerTimeOutException e) {
 *     // Log the timeout event
 *     // Provide an appropriate user-friendly error message
 *     // Take necessary corrective actions
 * }
 * ```
 */

/**
 @author Abhishek jadon
 @Date 23-Aug-2023
 @Time 11:49:48 am
 @Year 2023
 */
public class ServerTimeOutException extends Exception {


	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerTimeOutException() {
		
		// passing the user define message to super class constructor
		super("server takes too long to respond, kindly check your internet connection or try after sometime");
	}
	
}
