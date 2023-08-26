/**
 * 
 */
package com.abhi.briefbot.exceptions;



/**
 * The TextNotFoundException class represents an exception that is thrown when a
 * specific text cannot be found within a given context. This exception is useful
 * for scenarios where a search for specific content yields no results.
 *
 * Usage:
 * - Use this exception to handle situations where a required text or pattern is
 *   expected to be present, but it cannot be located.
 * - Catch this exception to implement appropriate error handling or fallback
 *   behavior when expected text is not found.
 *
 * Example:
 * ```
 * try {
 *     String searchText = "Hello, world!";
 *     String foundText = searchForText(searchText);
 *     if (foundText == null) {
 *         throw new TextNotFoundException("Required text not found: " + searchText);
 *     }
 *     // Continue processing with found text
 * } catch (TextNotFoundException e) {
 *     // Log the exception
 *     // Provide user-friendly error message
 *     // Implement fallback logic
 * }
 * ```
 */

/**
 @author Abhishek jadon
 @Date 23-Aug-2023
 @Time 11:35:44 am
 @Year 2023
 */

public class TextNotFoundException extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextNotFoundException() {
		super("Document contains no extractable text");
	}

}
