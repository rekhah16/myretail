package com.myretail.controller;

import com.myretail.model.Product;
import com.myretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductServiceController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET ,produces = "application/json")
    public ResponseEntity<Object> getProductDetail(@PathVariable String id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes = "application/json")
    public void updateProductInfo( @PathVariable ("id") String productId,@RequestBody Product product) {
        if(product == null) {
        }
        if(!product.getId().equals(productId)) {
        }
        productService.updateProduct(product);
    }



}
