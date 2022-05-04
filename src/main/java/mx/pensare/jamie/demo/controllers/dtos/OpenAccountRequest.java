package mx.pensare.jamie.demo.controllers.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OpenAccountRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;
}
