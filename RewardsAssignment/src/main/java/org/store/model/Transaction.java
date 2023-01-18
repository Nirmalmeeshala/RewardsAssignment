package org.store.model;

import lombok.Data;
import org.store.entity.Account;

import java.util.Date;

@Data
public class Transaction {
    private Integer id;
    private Account account;
    private int amount;
    private String details;
    private int rewards;
    private Date transactionDate;
}
