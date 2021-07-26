package com.home.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebAccountsService {

    String ACCOUNTS_SERVICE_URL = "http://accounts-service/";

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    protected String serviceUrl;

    public Account getByNumber(String accountNumber) throws AccountNotFoundException {

        Account account = restTemplate.getForObject(ACCOUNTS_SERVICE_URL
                + "/accounts/{number}", Account.class, accountNumber);

        if (account == null)
            throw new AccountNotFoundException(accountNumber);
        else
            return account;

    }
}