package com.abhi.briefbot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/*
 * AppProps is the class that contains the properties of the
 * project, specified properties in this class will never be 
 * change in the execution life cycle of the project
 * */

/**
 @author Abhishek jadon
 @Date 22-Aug-2023
 @Time 6:54:43 pm
 @Year 2023
 */


@Getter
@Setter
@NoArgsConstructor
@Component
@PropertySource("classpath:application-url.properties")
public class AppProps {
	
	
	@Value("${summary-api-key}")
	private String apiKey;
	
	@Value("${summary-api-url}")
	private String apiUrl;

}
