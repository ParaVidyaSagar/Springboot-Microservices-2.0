package com.custom.starter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;


class CustomLoggerStarterApplicationTests {

	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(RestClientAutoConfiguration.class, CustomPropertiesConfiguration.class));
			
	@Test
	void customRestClientBeanShouldExist() {
		contextRunner.run(context ->{
			assertTrue(context.containsBean("ExternalRestClient"));
			assertTrue(context.containsBean("customRestClient"));
			
		});
	}
	
	@Test
	void allowToOverridePrpoperties() {
		contextRunner.withPropertyValues("external.api.base-url=https://localhost:8080")
		.run((context) -> {
			assertThat(context).hasSingleBean(CustomProperties.class);
			assertThat(context.getBean(CustomProperties.class).baseUrl()).isEqualTo("https://localhost:8080");	
			});
	}

}
