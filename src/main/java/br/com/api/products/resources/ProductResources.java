package br.com.api.products.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.domain.Products;
import br.com.api.products.domain.ResponseH;
import br.com.api.products.services.ProductServices;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http//localhost:3000")
public class ProductResources {

    @Autowired
    private ProductServices services;

    @GetMapping
    public Iterable<Products> findAll() {
        return services.findAll();
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Products obj) {
        return services.updateInsert(obj, "insert");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Products obj, @PathVariable Long id) {
        obj.setId(id);
        return services.updateInsert(obj, "update");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseH> delete(@PathVariable Long id) {

        return services.delete(id);
    }

}
