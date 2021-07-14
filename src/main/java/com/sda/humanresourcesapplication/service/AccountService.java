package com.sda.humanresourcesapplication.service;

import com.sda.humanresourcesapplication.model.Account;
import com.sda.humanresourcesapplication.repository.AccountRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepositoryIF accountRepositoryIF;

    public Account saveAccount(Account account) {
        accountRepositoryIF.save(account);
        log.info("Account saved successfully.");
        return account;
    }

    public Integer deleteAccountById(Integer id) {
        Integer account = accountRepositoryIF.deleteAccountById(id);
        if (account != 0) {
            log.info("User with id: " + id + " has been deleted.");
        } else {
            log.warn("User has not been deleted.");
        }
        return account;
    }

    public List<Account> findAllAccounts() {
//        Iterable<Account> allUsers = accountRepositoryIf.findAll();
//        return (List<Account>) allUsers;
        return accountRepositoryIF.findAll();
    }
}
