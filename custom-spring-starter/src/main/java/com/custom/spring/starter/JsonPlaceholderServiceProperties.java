package com.custom.spring.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("Json-place-holder-property")
public record JsonPlaceholderServiceProperties(String Baseurl) 
{

}
