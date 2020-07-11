package com.myretail.service;

import com.myretail.model.Product;

public interface ProductService {

    public Product getProductById(String productId);

    public void updateProduct(Product product);


}
