package tuto.cucumber.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuto.cucumber.sample.model.Account;
import tuto.cucumber.sample.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Long saveAccount(Account account) {
        return accountRepository.save(account).getId();
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}
