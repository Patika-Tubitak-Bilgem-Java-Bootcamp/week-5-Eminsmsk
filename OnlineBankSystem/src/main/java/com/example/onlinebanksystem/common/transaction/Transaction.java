package com.example.onlinebanksystem.common.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Transaction {

    private String senderTCNo;
    private String receiverTCNo;
    private double amount;
    private TransactionType transactionType;
}
