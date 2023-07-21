package com.jpa.basic.service;

import com.jpa.basic.domain.ProductDTO;
import com.jpa.basic.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void write(ProductDTO productDTO);

    public Page<Product> getList(Pageable pageable);

    public Optional<Product> getProduct(Long id);

    public void update(ProductDTO productDTO);

    default Product toEntity(ProductDTO productDTO){
        return Product.builder().id(productDTO.getId())
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .productStock(productDTO.getProductStock())
                .build();
    }
}
