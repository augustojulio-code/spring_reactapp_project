package br.com.api.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.domain.Products;
import br.com.api.products.domain.ResponseH;
import br.com.api.products.repositories.ProductRepository;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ResponseH responseH;

    public Iterable<Products> findAll() {

        return repository.findAll();
    }

    public ResponseEntity<?> insert(Products products) {
        if (products.getName().equals("")) {
            responseH.setMsg("o nome do produto é obrigatorio");
            return new ResponseEntity<ResponseH>(responseH, HttpStatus.BAD_REQUEST);
        } else if (products.getBrand().equals("")) {
            responseH.setMsg("o nome da marca é obrigatorio");
            return new ResponseEntity<ResponseH>(responseH, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Products>(repository.save(products), HttpStatus.CREATED);
        }

    }

    public ResponseEntity<?> updateInsert(Products products, String action) {
        if (products.getName().equals("")) {
            responseH.setMsg("o nome do produto é obrigatorio");
            return new ResponseEntity<ResponseH>(responseH, HttpStatus.BAD_REQUEST);
        } else if (products.getBrand().equals("")) {
            responseH.setMsg("o nome da marca é obrigatorio");
            return new ResponseEntity<ResponseH>(responseH, HttpStatus.BAD_REQUEST);
        } else {

            if (action.equals("insert")) {

                return new ResponseEntity<Products>(repository.save(products), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Products>(repository.save(products), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<ResponseH> delete(Long id) {
        repository.deleteById(id);
        responseH.setMsg("Produto removido");

        return new ResponseEntity<ResponseH>(responseH, HttpStatus.OK);
    }

}
