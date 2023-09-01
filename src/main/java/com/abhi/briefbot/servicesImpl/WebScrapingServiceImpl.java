package com.abhi.briefbot.servicesImpl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.briefbot.services.WebScrapingService;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * The WebScrapingServiceImpl class implements the WebScrapingService interface
 * to provide functionality for fetching an HtmlPage corresponding to a given URL.
 * It uses web scraping techniques to retrieve the HTML content of a web page.
 *
 * Usage:
 * - Create an instance of this class to use its methods for fetching an HtmlPage
 *   corresponding to a given URL.
 * - Customize the implementation to handle various web scraping scenarios or
 *   requirements.
 *
 * Example:
 * ```java
 * WebScrapingService scrapingService = new WebScrapingServiceImpl();
 * String url = "https://example.com";
 * HtmlPage page = scrapingService.getHtmlPage(url);
 * // Process and manipulate the retrieved HtmlPage
 * ```
 *
 * @see WebScrapingService
 * @see WebClient
 * @see HtmlPage
 */

/**
 * 
 * @author Abhishek jadon
 * @Date 26-Aug-2023
 * @Time 1:00:12 pm
 * @Year 2023
 * @see WebClient
 * @see HtmlPage
 */

@Service
public class WebScrapingServiceImpl implements WebScrapingService {

	@Autowired
	private WebClient webClient;

	HtmlPage htmlpage;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public HtmlPage getHtmlPage(String url) throws Exception {

		try {

			// dissabling the javaScript of web page
			webClient.getOptions().setJavaScriptEnabled(false);

			// dissabling the css of web page
			webClient.getOptions().setCssEnabled(false);

			// fetching the HtmlPage
			htmlpage = webClient.getPage(url);

		} catch (FailingHttpStatusCodeException | IOException  e) {
			
			throw new FailingHttpStatusCodeException("Oops! It seems there was an issue with your webpage! May be not a valid page for Summarization.",null);

		} 
		
		logger.info("picked the htmlPage : {}", url);
		
		// returning the final htmlpage
		return htmlpage;
	}

}
