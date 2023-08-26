package com.abhi.briefbot.summary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.abhi.briefbot.exceptions.ServerTimeOutException;
import com.abhi.briefbot.exceptions.TextNotFoundException;
import com.abhi.briefbot.response.SummaryApiResponse;
import com.abhi.briefbot.utils.AppProps;


/**
 * The TextSummary class provides methods to convert extracted text into a summarized version
 * using the text summarization API from Edin AI. It utilizes the API to generate concise
 * summaries for the extracted content.
 *
 * Usage:
 * - Create an instance of this class to use its methods for text summarization.
 * - Set up the necessary configuration or authentication for accessing the Edin AI API.
 * - Use the methods defined in this class to summarize extracted text content.
 *
 * Example:
 * ```java
 * TextSummary textSummary = new TextSummary();
 * textSummary.setApiKey("YOUR_API_KEY");
 *
 * String extractedText = // retrieve the extracted text using ScrapedHtmlElementsService
 * String summary = textSummary.summarizeText(extractedText);
 * // Display or process the summarized text
 * ```
 *
 * @see ScrapedHtmlElementsService
 */

/**
 @author Abhishek jadon
 @Date 22-Aug-2023
 @Time 7:01:19 pm
 @Year 2023
 */

public class TextSummary {

	@Autowired
	AppProps appProps;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	/**
	@param text is the raw extracted text from web page.
	@return the final summarize text of the web page
	@throws ServerTimeOutException 
	@throws TextNotFoundException 
	@see SummaryApiResponse
	@see AppProps
	@see RestTemplate
	 */
	public SummaryApiResponse convertTextIntoSummary(String text) throws ServerTimeOutException, TextNotFoundException {
			
		ResponseEntity<SummaryApiResponse> responseEntity = null;
		try {
			
			if(text == null || text.length() == 0) {
				throw new TextNotFoundException();
			}
			
			// getting the api key and url for 
			String apiUrl = appProps.getApiUrl();
			String apiKey = appProps.getApiKey();
			
			// fitting the header content type and API key 
			HttpHeaders  headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + apiKey);
			
			
			// fitting the required parameters in API body
			Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("providers", "openai,connexun");
	        requestBody.put("text", text);
	        requestBody.put("language", "en");
	        requestBody.put("output_sentences", 50);
	        
	        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        	responseEntity = restTemplate.postForEntity(apiUrl, entity, SummaryApiResponse.class);
        	
        	
		} catch (RestClientException e) {
			throw new ServerTimeOutException();
		} catch (TextNotFoundException e) {
			throw new TextNotFoundException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseEntity.getBody();
		}
	
	
}
