package com.jpa.basic.repository;

import com.jpa.basic.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveTest(){
        for (int i=100; i<200; i++){
            Product product = new Product();
            product.setProductName("마우스" + (i + 1));
            product.setProductPrice(45000);
            product.setProductStock(55);

            productRepository.save(product);
        }
    }

    @Test
    public void findAllTest(){
        log.info(productRepository.findAll().toString());
    }

    @Test
    public void findAllWithPagingTest(){
        final Page<Product> productsWithPage = productRepository.findAllWithPaging(PageRequest.of(0, 10));
        log.info(productsWithPage.getContent().toString());
    }

//    @Test
//    public void updateTest(){
//        Optional<Product> foundProduct = productRepository.findById(121L);
//        foundProduct.ifPresent(product -> {
//            product.setProductName("수정된 상품명");
//            productRepository.updateById(product);
//        });
//    }

    @Test
    public void updatePricesTest(){
        productRepository.updatePrices();
    }


    @Test
    public void findAllByProductNameTest(){
        log.info(productRepository.findAllByProductName("5").toString());
    }

    @Test
    public void findAvgTest(){
        log.info("평균 가격 {}", productRepository.findAvg());
    }

    @Test
    public void deleteByProductNameTest(){
        productRepository.deleteByProductName("마우스");
    }
}













