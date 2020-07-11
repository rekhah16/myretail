package com.myretail.service;

import com.myretail.dao.repository.ProductPriceRepository;
import com.myretail.model.Price;
import com.myretail.model.Product;
import com.myretail.rest.client.ProductDataClient;
import com.myretail.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductPriceRepository productPriceRepository;

    @Autowired
    ProductDataClient client;

    @Value("${redsky.target.com_end_point}")
    private String endPointUrl;

    @Override
    public Product getProductById(String productId) {

        Optional<Price> price = this.productPriceRepository.findById(productId);
        if(price == null) {
            //throw new Exception(HttpStatus.NOT_FOUND, "http.resource.not.found");
        }
        Map map = client.getProductData(endPointUrl,productId,Map.class);
        Product product = new Product();
        product.setId(productId);
        product.setName(ProductUtil.getProductName(map));
        product.setPrice(price.get());

        return product;
    }

    @Override
    public void updateProduct(Product product) {
        productPriceRepository.save(product.getPrice());
    }

}
