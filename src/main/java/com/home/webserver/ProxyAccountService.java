package com.home.webserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "accounts-service",url = "localhost:2222")
public interface ProxyAccountService {

    @GetMapping("/accounts/{accountNumber}")
    public Account getAccountDetails(@PathVariable("accountNumber") String accountNumber);
}
