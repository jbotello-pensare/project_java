package mx.pensare.jamie.demo.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.pensare.jamie.demo.config.ConektaClient;
import mx.pensare.jamie.demo.config.ConektaConfiguration;
import mx.pensare.jamie.demo.controllers.dtos.GetOrderRequest;
import mx.pensare.jamie.demo.persistance.OrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {
    private String url;

    @Autowired
    private ConektaConfiguration conektaConfiguration;

    @Autowired
    private ConektaClient conektaClient;

    @GetMapping()
    public OrderResult getOrder(@RequestBody()GetOrderRequest getOrderRequest){
        url = conektaConfiguration.getGetOrderUrl() + getOrderRequest.getId();
        WebClient.ResponseSpec uriSpec = conektaClient.createClient().get()
                .uri(url)
                .retrieve();

        OrderResult response = uriSpec.bodyToMono(OrderResult.class).block();
        System.out.print(response);
        log.info("Response of Conekta service {}", response.toString());
        return response;

    }
}
