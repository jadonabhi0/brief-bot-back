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
 @author Abhishek jadon
 @Date 23-Aug-2023
 @Time 12:49:33 am
 @Year 2023
 */

@JsonIgnoreProperties
@Getter
@Setter
@NoArgsConstructor
public class OpenAi {
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("result")
	private String result;

}
