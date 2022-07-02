package io.github.gianhp.domain.entity;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Client {
    @Id
    @NotNull(message = "CPF é obrigatorio")
    private Long cpf;

    @NotNull(message = "Campo nome não pode ser nulo")
    private String nome;

    private String email;

    @NotNull(message = "Campo telefone não pode ser vazio")
    private String telefone;

    @DBRef
    private List<Product> items = new ArrayList<>(20);

}

