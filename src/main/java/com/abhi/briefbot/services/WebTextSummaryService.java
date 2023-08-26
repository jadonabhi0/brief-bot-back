package com.abhi.briefbot.services;

import com.abhi.briefbot.exceptions.TextNotFoundException;


/**
 * The WebTextSummaryService interface defines methods for fetching and extracting
 * the text content of a web page. Implementing classes provide the necessary
 * functionality to access web pages and retrieve their textual content.
 *
 * Usage:
 * - Implement this interface to create a service for fetching and summarizing
 *   the text content of web pages.
 * - Use the methods defined in this interface to retrieve and process the text
 *   content of a web page.
 *
 * Example:
 * ```java
 * public class MyWebTextSummaryService implements WebTextSummaryService {
 *
 *     @Override
 *     public String getAllSummary(String url) {
 *         // Implementation logic to fetch and summarize the text content of the web page
 *     }
 *
 *     // Implement other methods for text processing or additional functionality
 * }
 * ```
 */


public interface WebTextSummaryService {

	
	  /**
     * Fetches and summarizes the text content of the given web page URL.
     *
     * @param url The URL of the web page to fetch and summarize.
     * @return the text content of the web page.
	 * @throws Exception 
     */
	String getAllSummary(String url) throws TextNotFoundException, Exception;

}
