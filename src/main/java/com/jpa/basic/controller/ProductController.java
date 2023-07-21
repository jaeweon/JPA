package com.jpa.basic.controller;

import com.jpa.basic.domain.ProductDTO;
import com.jpa.basic.entity.Product;
import com.jpa.basic.exception.NoProductException;
import com.jpa.basic.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;

//    상품 추가
    @GetMapping("write")
    public void write(Model model){
        model.addAttribute("product", new ProductDTO());
    }

    @PostMapping("write")
    public RedirectView write(ProductDTO productDTO){
        productService.write(productDTO);
        return new RedirectView("/product/list");
    }

//    상품 목록
    @GetMapping("list")
    public void getList(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Model model){
        final Page<Product> pagination = productService.getList(pageable);
        model.addAttribute("pagination", pagination);
    }

    @GetMapping("/api/list")
    @ResponseBody
    public Slice<Product> getList(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return null;
    }

//    상품 상세보기
    @GetMapping(value={"read/{id}", "update/{id}"})
    public String read(@PathVariable Long id, Model model, HttpServletRequest request){
        final Product product = productService.getProduct(id).orElseThrow(() -> {
            throw new NoProductException("상품 없음");
        });
        model.addAttribute("product", product);
        return "/product/" + request.getRequestURI().split("/")[2];
    }

    @PostMapping("update")
    public RedirectView update(ProductDTO productDTO){
        productService.update(productDTO);
        return new RedirectView("/product/read/" + productDTO.getId());
    }
}