package com.abhi.briefbot.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.abhi.briefbot.preprocessing.DataCleaning;
import com.abhi.briefbot.summary.TextSummary;
import com.gargoylesoftware.htmlunit.WebClient;

/**
 * 
 * @author Abhishek jadon
 * @Date 20-Aug-2023
 * @Time 6:17:05 pm
 * @Year 2023
 */

// This is the configuration class of my Applicaton, beans has been declaired in this class

@Configuration
public class AppConfiguration {

	@Bean
	WebClient getWebClientInstance() {
		return new WebClient();
	}

	@Bean
	RestTemplate getRestTemplateInstance(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	DataCleaning getDataCleaningInstance() {
		return new DataCleaning();
	}

	@Bean
	TextSummary getTextSummaryInstance() {
		return new TextSummary();
	}

}
