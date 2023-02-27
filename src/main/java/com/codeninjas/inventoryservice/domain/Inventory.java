package com.codeninjas.inventoryservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {

    @Id
    @Generated
    private String inventoryId;

    @NotNull(message = "item code can't be null")
    @NotBlank(message = "item code can't be blank")
    private String itemCode;

    @NotNull(message = "quantity can't be null")
    @NotBlank(message = "quantity can't be blank")
    private int quality;
}
