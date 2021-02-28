package com.vinsguru.cacheaside.service;

import java.util.Optional;

import com.vinsguru.cacheaside.dto.ProductDto;

public interface ProductService {
	Optional<ProductDto> getProduct(long id);
	void updateProduct(ProductDto productDto);
}
