package com.custom.starter.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.custom.starter.aspect.LogExecutionTimeAspect;

@Configuration
@ConditionalOnClass(LogExecutionTimeAspect.class)
public class CustomStarterAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public LogExecutionTimeAspect logExecutionTimeAspect() {
		return new LogExecutionTimeAspect();
	}
}
