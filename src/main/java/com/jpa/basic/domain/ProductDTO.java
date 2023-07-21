package com.jpa.basic.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
}
