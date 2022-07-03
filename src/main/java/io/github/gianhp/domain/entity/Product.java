package io.github.gianhp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @NotNull(message = "Codigo do produto é obrigátorio")
    private Integer code;

    @NotNull(message = "Nome do produto é obrigátorio")
    private String description;

    @NotNull(message = "O tamanho do produto é obrigátorio")
    private String size;

    @NotNull(message = "O valor do produto é obrigátorio")
    private BigDecimal value;

}
