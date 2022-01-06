package com.example.product_be.controller;

import com.example.product_be.dto.ResponseMessage;
import com.example.product_be.model.Product;
import com.example.product_be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/products")
public class ProductRestfulController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllProducts() {
        List<Product> productList = (List<Product>) productService.findAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        if (product.getName() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_name"), HttpStatus.OK);
        }
        if (product.getDateOfManufacture() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_date"), HttpStatus.OK);
        }
        if (product.getAvatarProduct() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_avatar"), HttpStatus.OK);
        }
        if (product.getDescription() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_description"), HttpStatus.OK);
        }
        productService.save(product);
        return new ResponseEntity<>(new ResponseMessage("success"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (product.getName() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_name"), HttpStatus.OK);
        }
        if (product.getDateOfManufacture() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_date"), HttpStatus.OK);
        }
        if (product.getAvatarProduct() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_avatar"), HttpStatus.OK);
        }
        if (product.getDescription() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_description"), HttpStatus.OK);
        }
        product.setId(productOptional.get().getId());
        productService.save(product);

        return new ResponseEntity<>(new ResponseMessage("success"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.NO_CONTENT);
    }

}
