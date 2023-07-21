package com.jpa.basic.service;

import com.jpa.basic.domain.ProductDTO;
import com.jpa.basic.entity.Product;
import com.jpa.basic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void write(ProductDTO productDTO) {
        productRepository.save(toEntity(productDTO));
    }

    @Override
    @Transactional
    public Page<Product> getList(Pageable pageable) {
        return productRepository.findAllWithPaging(pageable);
    }

    @Override
    @Transactional
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void update(ProductDTO productDTO) {
        productRepository.updateById(toEntity(productDTO));
    }
}
