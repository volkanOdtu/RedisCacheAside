package com.vinsguru.cacheaside.controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinsguru.cacheaside.dto.ProductDto;
import com.vinsguru.cacheaside.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> getProductDto(@PathVariable long id){
		System.out.println("request came");
		return this.productService.getProduct(id)
							.map(ResponseEntity::ok)
							.orElse(ResponseEntity.noContent().build());
	}
	
	@PatchMapping("/product")
	public void updateProduct(@RequestBody ProductDto dto) {
		System.out.println("request update");
		this.productService.updateProduct(dto);
	}
}
