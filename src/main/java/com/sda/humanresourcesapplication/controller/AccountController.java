package com.sda.humanresourcesapplication.controller;

import com.sda.humanresourcesapplication.model.Account;
import com.sda.humanresourcesapplication.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/humanresources/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<String> findAllAccounts() {
        List<Account> accountList = accountService.findAllAccounts();
        log.info("Accounts found.");
        log.debug(accountList.toString());
        return new ResponseEntity<>(accountList.toString(), HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        log.info(account.toString());
        return new ResponseEntity<>(account.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/accounts")
    @Transactional
    public ResponseEntity<String> deleteAccount(@RequestParam(value = "id") Integer id) {
        Integer result;
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        } else {
            result = accountService.deleteAccountById(id);
            if (result == 0) {
                log.info("Account did not get deleted");
                return new ResponseEntity<>("Account does not exist. We do not have what to delete", HttpStatus.I_AM_A_TEAPOT);
            } else {
                log.info("account has been removed");
                return new ResponseEntity<>("Account with id " + id + "hsd been removed.", HttpStatus.OK);
            }

        }

    }

    @PutMapping("/accounts")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account updateAccount = accountService.saveAccount(account);
        return ResponseEntity.ok(updateAccount);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal Arguments " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
