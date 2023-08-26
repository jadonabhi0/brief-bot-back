/**
 * 
 */
package com.abhi.briefbot.response.fail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



/**
 * <p>The ExceptionMessage class encapsulates error information received from
 * the OpenAI API when a request encounters a failure. It provides methods
 * to access and handle details about the error.
 *
 * Usage:
 * - Use this class to parse and extract error information from the failure
 *   response of the OpenAI API.
 * - Access the error message, error code, and other relevant details using
 *   the provided methods.
 *
 */

/**
 @author Abhishek jadon
 @Date 23-Aug-2023
 @Time 12:52:12 am
 @Year 2023
 */

@Getter
@Setter
@AllArgsConstructor
public class ExceptionMessage {

	private boolean success;
	
	private String message;
	
}
