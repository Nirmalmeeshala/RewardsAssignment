package org.store.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="acc_id", nullable=false)
    private Account account;
    private String details;
    private int amount;
    private int rewards;
    private Date transactionDate;
}
