package org.store.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.store.model.Account;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountService accountService;
    @Test
    public void testRewards(){
        ArrayList<Account> accounts = new ArrayList<>();
        when(accountService.getAccounts()).thenReturn(accounts);
        List<Account> accountList = accountService.getAccounts();
        Assertions.assertEquals(accounts, accountList);
    }
}
