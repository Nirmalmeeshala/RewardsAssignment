package org.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.model.Account;
import org.store.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class RewardController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/rewards")
    public ResponseEntity<List<Account>> getAccountRewards(){
        ResponseEntity<List<Account>> response = null;
        List<Account> accountsFromService = accountService.getAccounts();
        response = new ResponseEntity<>(accountsFromService, HttpStatus.OK);
        return  response;
    }
}
