package org.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.entity.Transaction;
import org.store.model.Account;
import org.store.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    public List<Account> getAccounts(){
        List<org.store.entity.Account> accountList = accountRepository.findAll();
        List<org.store.model.Account> account = calculateRewardsAccounts(accountList);
        return null;
    }

    private List<Account> calculateRewardsAccounts(List<org.store.entity.Account> accountList) {
        List<Account> accounts = null;
        if(accountList != null && !accountList.isEmpty()){
            accounts = accountList.stream().map(acc-> rewards(acc)).collect(Collectors.toList());
        }
        return  accounts;
    }

    private Account rewards(org.store.entity.Account acc) {
        Account account = null;
        if(acc != null){
            List<Transaction> transactions = acc.getTransactions();
            if(transactions != null && !transactions.isEmpty()){
                List<Transaction> transactionList = transactions.stream().map(transaction -> {
                    int rewards = 0;
                    int amount = transaction.getAmount();
                    rewards += ((amount % 100)) * 2);
                    rewards += ((amount / 50) * 1);
                    transaction.setRewards(rewards);
                    return transaction;
                }).collect(Collectors.toList());
                account = new Account();
                account.setTransactions(transactionList);
                account.setId(acc.getId());
                account.setName(acc.getName());
            }
        }
        return  account;
    }
}
