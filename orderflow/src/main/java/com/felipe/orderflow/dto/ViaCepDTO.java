package com.felipe.orderflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViaCepDTO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
