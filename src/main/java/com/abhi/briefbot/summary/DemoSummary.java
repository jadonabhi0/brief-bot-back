/**
 * 
 */
package com.abhi.briefbot.summary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.abhi.briefbot.response.ApiResponse;

/**
 @author Abhishek jadon
 @Date 24-Aug-2023
 @Time 7:21:14 am
 @Year 2023
 */

@Component
public class DemoSummary {
	
	@Autowired
	RestTemplate restTemplate;
	
	public ApiResponse getSummartDemo(String text) {
		System.out.println(text);
		String url = "https://text-analysis12.p.rapidapi.com/summarize-text/api/v1.1";
		
		HttpHeaders  headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("content-type", "application/json");
		headers.set("X-RapidAPI-Key", "3990766dc8mshcfd66dff6bc62fcp150b58jsnfbeafcd65c6b");
		headers.set("X-RapidAPI-Host", "text-analysis12.p.rapidapi.com");
		
		
		Map<String, Object> requestBody = new HashMap<>();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        requestBody.put("language", "english");
        requestBody.put("summary_percent", 50);
        requestBody.put("text", text);
        
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
    	ResponseEntity<ApiResponse> responseEntity = restTemplate.postForEntity(url, entity, ApiResponse.class);
    	return responseEntity.getBody();
	}

}
