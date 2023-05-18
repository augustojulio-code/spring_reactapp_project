package br.com.api.products.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.domain.Products;
import br.com.api.products.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductResources {

    @Autowired
    private ProductServices services;

    @GetMapping
    public Iterable<Products> findAll() {
        return services.findAll();
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Products obj) {
        return services.insert(obj);
    }

}
