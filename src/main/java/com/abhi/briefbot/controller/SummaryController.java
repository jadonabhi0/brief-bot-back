package com.abhi.briefbot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.briefbot.entity.Url;
import com.abhi.briefbot.exceptions.ServerTimeOutException;
import com.abhi.briefbot.exceptions.TextNotFoundException;
import com.abhi.briefbot.response.SummaryApiResponse;
import com.abhi.briefbot.services.WebTextSummaryService;
import com.abhi.briefbot.summary.TextSummary;


	/**
	@author Abhishek jadon
	@Date 23-Aug-2023
	@Time 1:12:08 am
	@Year 2023
	*/


/**
 * The SummaryController class handles HTTP requests to retrieve summaries of web pages.
 * It acts as an intermediary between the user interface and the summarization logic.
 * This controller provides methods to generate and serve concise summaries of web content.
 *
 * Usage:
 * - This controller maps incoming HTTP requests to methods that generate and return
 *   summaries of web page content.
 * - Use this controller to facilitate content summarization for better user experience.
 *
 * Example:
 * ```
 * @Controller
 * @RequestMapping("/summary")
 * public class SummaryController {
 *
 *     @Autowired
 *     private WebPageSummarizer summarizer;
 *
 *     @GetMapping("/generate")
 *     public ResponseEntity<?> generateSummary(@RequestParam("url") String url) {
 *         // Implementation logic to generate a summary of the web page
 *     }
 *
 *     // Other controller methods for different summarization operations
 * }
 * ```
 *
 * @see WebPageSummarizer
 */



@RestController
@RequestMapping(value = "/api/response")
public class SummaryController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	WebTextSummaryService webTextSummaryService;
	
	@Autowired
	TextSummary textSummary;
	

	
	
	/**
	 * 
	 * 
	@Date 23-Aug-2023
	@Time 1:11:42 am
	@param url
	
	@return the final response
	@throws Exception 
	@see SummaryApiResponse
	@see TextSummary
	 */
	
	@PostMapping("/allsummary")
	public ResponseEntity<SummaryApiResponse> getSummaryByPara(@RequestBody Url apiUrl) throws Exception{
		
		logger.info("Requested for : {}", apiUrl.getUrl());
		
		SummaryApiResponse convertTextIntoSummary = null;
		try {
			
			// Reciving the extracted and preprocessed text of the web page.
			String allSummary = webTextSummaryService.getAllSummary(apiUrl.getUrl());
			
			logger.info("Non-summarized content: {}",allSummary);
			
			// converting the recived text into final summary.
			convertTextIntoSummary = textSummary.convertTextIntoSummary(allSummary);
			logger.info("Summarized content: {}", convertTextIntoSummary);
			System.out.println(convertTextIntoSummary.toString());
			
		} catch (ServerTimeOutException e) {
			logger.error("Error occuring : {}", e.getMessage());
			throw new ServerTimeOutException();
		} catch (TextNotFoundException e) {
			logger.error("Error occuring : {}", e.getMessage());
			throw new TextNotFoundException();
		}
		
		// returning the final extracted and summarized text.
		logger.info("Returned Summarized Data");
		return new ResponseEntity<SummaryApiResponse>(convertTextIntoSummary, HttpStatus.OK);

	}
	


}
