package com.fastcampus.kafkahandson.ugc.meta.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MetadataWebClientConfig {

	@Value("${metadata.api.url}")
	private String metadataApiUrl;

	@Bean
	@Primary
	public WebClient metadataWebClient() {
		return WebClient.builder().baseUrl(metadataApiUrl).build();
	}

}
