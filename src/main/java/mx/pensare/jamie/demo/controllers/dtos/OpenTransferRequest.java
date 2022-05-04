package mx.pensare.jamie.demo.controllers.dtos;

import lombok.Data;
import mx.pensare.jamie.demo.persistance.Account;

import javax.validation.constraints.NotBlank;

@Data
public class OpenTransferRequest {
    @NotBlank(message = "Name is mandatory")
    private Account sourceAccount;
    private String destinationAccount;
    private String concept;
    private Double amount;
}
