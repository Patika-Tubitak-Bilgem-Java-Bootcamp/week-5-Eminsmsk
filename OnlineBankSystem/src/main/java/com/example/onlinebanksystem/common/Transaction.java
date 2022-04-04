package com.example.onlinebanksystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private String senderTCNo;
    private String receiverTCNo;
    private double amount;
    private TransactionType transactionType;
}
