package com.abhi.briefbot.services;

import com.gargoylesoftware.htmlunit.html.HtmlPage;


/**
 * The WebScrapingService interface defines methods for fetching and interacting
 * with web pages, returning an HtmlPage representation of the current URL.
 * Implementing classes provide the necessary functionality to access web pages
 * and retrieve their HTML content.
 *
 * Usage:
 * - Implement this interface to create a service for web scraping and fetching
 *   HtmlPage instances for given URLs.
 * - Use the methods defined in this interface to fetch and manipulate web pages.
 *
 * Example:
 * ```java
 * public class MyWebScrapingService implements WebScrapingService {
 *
 *     @Override
 *     public HtmlPage getHtmlPage(String url) {
 *         // Implementation logic to fetch and return the HtmlPage for the given URL
 *     }
 *
 *     // Implement other methods for interacting with web pages
 * }
 * ```
 *
 * @see HtmlPage
 */


/**
 * 
 @author Abhishek jadon
 @Date 26-Aug-2023
 @Time 12:35:25 pm
 @Year 2023
 */
public interface WebScrapingService {
	
	
    /**
     * Fetches an HtmlPage corresponding to the given URL.
     *
     * @param url The URL of the web page to fetch.
     * @return The HtmlPage representation of the fetched web page.
     * @throws Exception 
     */
	
	HtmlPage getHtmlPage(String url) throws Exception;

}
