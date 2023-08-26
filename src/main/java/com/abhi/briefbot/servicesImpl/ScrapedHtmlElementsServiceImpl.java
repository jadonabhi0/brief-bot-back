package com.abhi.briefbot.servicesImpl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.briefbot.exceptions.TextNotFoundException;
import com.abhi.briefbot.preprocessing.DataCleaning;
import com.abhi.briefbot.services.ScrapedHtmlElementsService;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * The ScrapedHtmlElementsServiceImpl class implements the ScrapedHtmlElementsService
 * interface to provide functionality for extracting text content from HTML elements
 * within an HtmlPage. It uses web scraping techniques to navigate through the HTML
 * structure and extract desired data.
 *
 * Usage:
 * - Create an instance of this class to use its methods for extracting text content
 *   from HTML elements within an HtmlPage.
 * - Customize the implementation to handle various element extraction scenarios or
 *   requirements.
 *
 * Example:
 * ```java
 * ScrapedHtmlElementsService elementsService = new ScrapedHtmlElementsServiceImpl();
 * HtmlPage page = // fetch the HtmlPage using a WebScrapingService
 * String headingText = elementsService.extractHeadingText(page, 1);
 * String paragraphTexts = elementsService.extractParagraphTexts(page);
 * // Process and display the extracted text content
 * ```
 *
 * @see ScrapedHtmlElementsService
 * @see DataCleaning
 */

@Service
public class ScrapedHtmlElementsServiceImpl implements ScrapedHtmlElementsService {

	@Autowired
	DataCleaning dataCleaning;
	


	@Override
	public String getHtmlParagraphText(HtmlPage htmlPage, String tag) throws TextNotFoundException {
		// getting the list of all selected tabs
		DomNodeList<HtmlElement> elementsByTagName = htmlPage.getBody().getElementsByTagName(tag);
		StringBuilder sb = new StringBuilder();
		
		// iterating the domeList of DOM
		Iterator<HtmlElement> iterator = elementsByTagName.iterator();
		while (iterator.hasNext()) {
			DomElement domElement = (DomElement) iterator.next();
			
			// get the textcontent of html element
			String text = domElement.getTextContent();
			
			// if the length of text contant is less than 5 neglect it
			if(text.length() <= 5) continue;
			
			if(domElement.mayBeDisplayed())sb.append(text);
		}
		// if the total content length is less than 500 claracters
		if(sb.length() < 500) {
			throw new TextNotFoundException();
		}

		// finally clean the extracted text
		String cleanData = dataCleaning.cleanData(sb.toString());
		
		return cleanData;
		
	}



}
