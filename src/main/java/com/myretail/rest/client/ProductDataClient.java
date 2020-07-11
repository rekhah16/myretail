package com.myretail.rest.client;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductDataClient {

    RestTemplate restTemplate = new RestTemplate();

    public <T> T getProductData(String url, String productId, Class<T> responseType) {
        try {
            return restTemplate.getForObject(url, responseType, productId);

        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // throw new BaseException(e.getStatusCode(), "http.resource.not.found");
            }
        }
        return null;

    }

}
