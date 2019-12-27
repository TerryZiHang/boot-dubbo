package org.szh.application;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages="org.szh")
@ImportResource(locations= {"dubbo-consumer.xml"})
@EnableSwagger2
public class ConsumerApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{
	
	private static Logger logger = Logger.getLogger(ConsumerApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ConsumerApplication.class);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(7777);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		logger.debug("==== APP Start ON SpringBoot Success ====");
	}

}
