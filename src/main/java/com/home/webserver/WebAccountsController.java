package com.home.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebAccountsController {

    @Autowired
    WebAccountsService webAccountsService;

    @Autowired
    ProxyAccountService proxyAccountService;


    @GetMapping("/accounts")
    public Account getAccountDetails() throws AccountNotFoundException {
        return webAccountsService.getByNumber("123");
    }


    @GetMapping("/accounts/feign")
    public Account getAccountDetailsThroughFeign() throws AccountNotFoundException {
        return proxyAccountService.getAccountDetails("123");
    }

}
