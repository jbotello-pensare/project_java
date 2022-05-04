package mx.pensare.jamie.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ConektaClient {

    @Autowired
    private ConektaConfiguration conektaConfiguration;

    public WebClient createClient() {
         return WebClient.builder()
                .baseUrl(conektaConfiguration.getUrlBase())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, "application/vnd.conekta-v2.0.0+json")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + conektaConfiguration.getApiKey())
                .build();
    }
}
