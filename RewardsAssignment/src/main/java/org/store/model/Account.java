package org.store.model;

import lombok.Data;
import org.store.entity.Transaction;

import java.util.List;

@Data
public class Account {
    private Integer id;
    private String name;
    private List<Transaction> transactions;
}
