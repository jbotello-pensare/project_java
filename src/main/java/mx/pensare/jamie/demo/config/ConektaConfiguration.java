package mx.pensare.jamie.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class ConektaConfiguration {

    @Value("${conekta.api.authorization.key}")
    private String apiKey;

    @Value("${conekta.api.base.url}")
    private String urlBase;

    @Value("${conekta.api.orders.get.url}")
    private String getOrderUrl;

}
