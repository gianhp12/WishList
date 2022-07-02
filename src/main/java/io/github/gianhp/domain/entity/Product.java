package io.github.gianhp.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
@Document
public class Product {
    @Id
    private Integer code;

    @DBRef
    private Client client;

    @NotNull(message = "Nome do produto é obrigátorio")
    private String description;

    @NotNull(message = "O tamanho do produto é obrigátorio")
    private String size;

    @NotNull(message = "O valor do produto é obrigátorio")
    private BigDecimal value;

}
