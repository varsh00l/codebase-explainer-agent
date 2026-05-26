package com.sonu.codebase_explainer.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebClientConfig {
    @Bean
        public WebClient gitHubWebClient() {
            return WebClient.builder()
                    .baseUrl("https://api.github.com")
                    .defaultHeader("Accept", "application/vnd.github.v3+json")
                    .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(10 * 1024 * 1024))
                    .build();
        }
    }
