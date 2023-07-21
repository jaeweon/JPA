package com.jpa.basic.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @ToString @Setter
@Table(name = "TBL_PRODUCT")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String productName;
    private Integer productPrice;
    private Integer productStock;

    @Builder
    public Product(Long id, String productName, Integer productPrice, Integer productStock) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}



















