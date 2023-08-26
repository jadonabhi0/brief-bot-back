package com.abhi.briefbot.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.abhi.briefbot.preprocessing.DataCleaning;
import com.abhi.briefbot.summary.TextSummary;
import com.abhi.briefbot.utils.AppProps;
import com.gargoylesoftware.htmlunit.WebClient;

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
