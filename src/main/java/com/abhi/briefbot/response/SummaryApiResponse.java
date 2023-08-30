package com.abhi.briefbot.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>The ApiResponse class encapsulates the response received from the OpenAI API
 * for text summarization. It provides structre to extracted relevant information
 * from the API response and handle common response properties.
 *
 * Usage:
 * - Use this class to parse and handle responses from the OpenAI API after
 *   making a text summarization request.
 * - Extract summary text, confidence scores, and other information using the
 *   provided methods.
 *

 */

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryApiResponse {

	private boolean success = true;
	
	@JsonProperty("openai")
	private OpenAi openAi;

}
