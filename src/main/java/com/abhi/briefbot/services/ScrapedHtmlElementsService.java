package com.abhi.briefbot.services;

import com.abhi.briefbot.exceptions.TextNotFoundException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * The ScrapedHtmlElementsService interface defines methods for extracting text content
 * from HTML elements within an HtmlPage. Implementing classes provide the necessary
 * functionality to navigate and extract data from web pages.
 *
 * Usage:
 * - Implement this interface to create a service for scraping text content from HTML
 *   elements within an HtmlPage.
 * - Use the methods defined in this interface to extract specific content such as
 *   headings, paragraphs, and other relevant elements.
 *
 * Example:
 * ```java
 * public class MyHtmlElementsService implements ScrapedHtmlElementsService {
 *
 *     @Override
 *     public String getHtmlParagraphText(HtmlPage page, int headingLevel) {
 *         // Implementation logic to extract text from the specified heading level
 *     }
 *
 *     // Implement other methods to extract various types of HTML elements
 * }
 * ```
 *
 * @see HtmlPage
 */




/**
 * 
 @author Abhishek jadon
 @Date 26-Aug-2023
 @Time 12:32:01 pm
 @Year 2023
 */
public interface ScrapedHtmlElementsService {
	
	
	/**
     * Extracts text content from an HTML element of the specified level.
     *
     * @param page The HtmlPage containing the HTML content.
     * @param tag The level of the heading element (e.g., 1 for <h1>, 2 for <h2>).
     * @return The text content of the specified  element, or an empty string if not found.
     */

	String getHtmlParagraphText(HtmlPage htmlPage, String tag) throws TextNotFoundException;
	
}
