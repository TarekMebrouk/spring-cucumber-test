package tuto.cucumber.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tuto.cucumber.sample.model.Account;
import tuto.cucumber.sample.service.AccountService;

import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private AccountService accountService;

    @Value(value = "${app.version}")
    private String APPLICATION_VERSION;

    @GetMapping("/version")
    public String getVersion() {
        return Optional.ofNullable(APPLICATION_VERSION).orElse("N/A");
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

}
