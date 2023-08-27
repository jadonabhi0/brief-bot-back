package com.abhi.briefbot.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.briefbot.exceptions.TextNotFoundException;
import com.abhi.briefbot.services.WebScrapingService;
import com.abhi.briefbot.services.WebTextSummaryService;
import com.gargoylesoftware.htmlunit.html.HtmlPage;



/**
 * The WebTextSummaryServiceImpl class implements the WebTextSummaryService interface
 * to provide functionality for fetching and summarizing the text content of web pages.
 * It uses web scraping techniques to retrieve the HTML content of a web page and then
 * extracts and summarizes the text content.
 *
 * Usage:
 * - Create an instance of this class to use its methods for fetching and summarizing
 *   the text content of web pages.
 * - Customize the implementation to handle various summarization techniques or data
 *   processing requirements.
 *
 * Example:
 * ```java
 * WebTextSummaryService textSummaryService = new WebTextSummaryServiceImpl();
 * String url = "https://example.com";
 * String summary = textSummaryService.summarizeWebPage(url);
 * // Process and display the summarized text content
 * ```
 *
 * @see WebTextSummaryService
 * @see WebScrapingService
 * @see ScrapedHtmlElementsServiceImpl
 */



@Service
public class WebTextSummaryServiceImpl implements WebTextSummaryService {
	
	@Autowired
	WebScrapingService webScrapingService;
	
	@Autowired
	ScrapedHtmlElementsServiceImpl scrapedHtmlElementsServiceImpl;

	@Override
	public String getAllSummary(String url) throws Exception {
		
		// getting the web page htmlPage
		HtmlPage htmlPage = webScrapingService.getHtmlPage(url);
		String htmlParagraphText = null;
		try {
			
			// getting the text
			htmlParagraphText = scrapedHtmlElementsServiceImpl.getHtmlParagraphText(htmlPage, "p");
		} catch (TextNotFoundException e) {
			e.printStackTrace();
			throw new TextNotFoundException();
			
		}
		
		// returnint the text of webpage
		return htmlParagraphText;
	}



}
