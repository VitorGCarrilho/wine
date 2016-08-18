package com.algaworks.wine.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.HttpStatus;

@Configuration
public class WebConfig extends WebMvcAutoConfigurationAdapter {
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
			return(container -> 
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"))
			);
		
	}
	
	@Bean
	public DomainClassConverter<FormattingConversionService> domainClassConverter(
			FormattingConversionService conversionService){
		return new DomainClassConverter<FormattingConversionService>(conversionService);
		
	}
	
}
