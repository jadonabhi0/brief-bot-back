/**
 * 
 */
package com.abhi.briefbot.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * <p>The ApiResponse class encapsulates the response received from the OpenAI API
 * for text summarization. It provides methods to extract relevant information
 * from the API response and handle common response properties.
 *
 * Usage:
 * - Use this class to parse and handle responses from the OpenAI API after
 *   making a text summarization request.
 * - Extract summary text, confidence scores, and other information using the
 *   provided methods.
 *

 */



/**
 @author Abhishek jadon
 @Date 24-Aug-2023
 @Time 7:27:44 am
 @Year 2023
 @see OpenAi
 */
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ApiResponse {
	
	@JsonProperty("time_taken")
	private double timeTaken;
	
	@JsonProperty("msg")
	private String message;

	@JsonProperty("ok")
	private boolean ok;
	
	@JsonProperty("sentence_count")
	private int sentenceCount;
	
	@JsonProperty("summary")
	private String summary;
	
	@JsonProperty("sentences")
	private String[] sentences;
	
}
