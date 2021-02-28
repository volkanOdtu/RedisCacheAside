package com.vinsguru.cacheaside.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vinsguru.cacheaside.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
