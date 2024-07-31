package com.thymeleaf.suap.model;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
@Data
public class Endereco {
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;


}
