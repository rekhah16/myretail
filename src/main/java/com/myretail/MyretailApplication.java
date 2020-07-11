package com.myretail;

import com.myretail.dao.repository.ProductPriceRepository;
import com.myretail.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;

@EnableMongoRepositories(value ={"com.myretail.dao.repository"})
@SpringBootApplication
public class MyretailApplication {

    @Autowired
    ProductPriceRepository productPriceRepository;

    public static void main(String[] args) {
        System.getProperties().put("server.port", 8090);
        SpringApplication.run(MyretailApplication.class, args);
    }

    @PostConstruct
    public void loadInitialData() {
        productPriceRepository.deleteAll();
        Price price = new Price();
        price.setId("13860428");
        price.setCurrency_code("USD");
        price.setValue(77.98);

        Price price1 = new Price();
        price.setId("16696652");
        price.setCurrency_code("USD");
        price.setValue(17.66);
        productPriceRepository.insert(price);
        productPriceRepository.insert(price1);

    }
}

