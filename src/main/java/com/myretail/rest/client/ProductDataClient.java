package com.myretail.rest.client;

import com.myretail.exception.MyRetailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductDataClient {

    RestTemplate restTemplate = new RestTemplate();
    protected Logger logger = LoggerFactory.getLogger(ProductDataClient.class); // implement logging

    public <T> T getProductData(String url, String productId, Class<T> responseType) {
        try {
            return restTemplate.getForObject(url, responseType, productId);
        } catch (Exception ex) {
            logger.error("Error while calling api redsky.target.com {}", ex);
            throw new MyRetailException("Error while calling api redsky.target.com");
        }
    }

}
