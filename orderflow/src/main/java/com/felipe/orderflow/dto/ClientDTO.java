package com.felipe.orderflow.dto;

import com.felipe.orderflow.entities.Client;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;

    private String street;
    private String number;
    private String city;
    private String state;
    private String zipCode;

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.cpf = entity.getCpf();
        this.phone = entity.getPhone();
        this.street = entity.getStreet();
        this.number = entity.getNumber();
        this.city = entity.getCity();
        this.state = entity.getState();
        this.zipCode = entity.getZipCode();
    }
}
