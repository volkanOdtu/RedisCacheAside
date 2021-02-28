package com.vinsguru.cacheaside.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vinsguru.cacheaside.dto.ProductDto;
import com.vinsguru.cacheaside.entity.Product;
import com.vinsguru.cacheaside.repository.ProductRepository;
import com.vinsguru.cacheaside.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Cacheable("product")
	public Optional<ProductDto> getProduct(long id) {
		return this.productRepository.findById(id)
				.map(this::entityToDto);
	}

	@Override
	@CacheEvict(value = "product" ,key = "#productDto.id")
	public void updateProduct(ProductDto productDto) {
		
		this.productRepository.findById(productDto.getId())
							   .map(p -> this.setQuantityAvailable(p ,productDto))
								.ifPresent(this.productRepository::save);
		
		
	}
	
	   private ProductDto entityToDto(Product product){
	        ProductDto dto = new ProductDto();
	        dto.setId(product.getId());
	        dto.setDescription(product.getDescription());
	        dto.setPrice(product.getPrice());
	        dto.setQtyavailable(product.getQtyavailable());
	        return dto;
	    }

	    private Product setQuantityAvailable(Product product, ProductDto dto){
	        product.setQtyavailable(dto.getQtyavailable());
	        return product;
	    }
}
