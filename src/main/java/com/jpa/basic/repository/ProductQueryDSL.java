package com.jpa.basic.repository;

import com.jpa.basic.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductQueryDSL {
//    상품 목록
    public List<Product> findAll();

//    상품 목록 페이징 처리
    public Page<Product> findAllWithPaging(Pageable pageable);

//    상품 이름 수정
    public void updateById(Product product);

//    평균 가격보다 낮은 상품 가격 10% 인상
    public void updatePrices();

//    상품 이름 중 5가 포함된 상품 정보 조회
    public List<Product> findAllByProductName(String keyword);

//    전체 상품 평균 가격 조회
    public double findAvg();

//    이름으로 상품 삭제(이름은 포함이 아닌 같은 지 검사)
    public void deleteByProductName(String productName);
}
