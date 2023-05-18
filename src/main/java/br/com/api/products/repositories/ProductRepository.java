package br.com.api.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.products.domain.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
