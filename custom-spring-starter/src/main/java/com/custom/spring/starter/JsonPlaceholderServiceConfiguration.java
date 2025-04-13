package com.custom.spring.starter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.custom.spring.starter.todo.JpsTodoClient;



@AutoConfiguration
@EnableConfigurationProperties(JsonPlaceholderServiceProperties.class)
public class JsonPlaceholderServiceConfiguration {
	private static final Logger log = LoggerFactory.getLogger(JsonPlaceholderServiceConfiguration.class);
    private final JsonPlaceholderServiceProperties jpsProperties;
 
    public JsonPlaceholderServiceConfiguration(JsonPlaceholderServiceProperties properties) {
    	log.info("Configuration JsonPlaceHolderService with properties: {}", properties);
    	jpsProperties = properties;
    	}
    
    @Bean
    JpsTodoClient jpsTodoClient(RestClient restClient) {
    	return new JpsTodoClient(restClient);
    }
	
    
    @Bean("jsonPlaceHolderRestClient")
    RestClient restClient(RestClient.Builder builder) {
    	return builder
    			.baseUrl(jpsProperties.Baseurl())
    			.build();
    	
    }
	

}
