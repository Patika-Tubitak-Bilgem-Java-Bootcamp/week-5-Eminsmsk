package com.example.onlinebanksystem.common.request;

import com.example.onlinebanksystem.common.transaction.Transaction;
import com.example.onlinebanksystem.common.transaction.TransactionType;

public class MoneyTransferRequest extends Transaction {

    public MoneyTransferRequest(String senderTCNo, String receiverTCNo, double amount) {
        super(senderTCNo, receiverTCNo, amount, TransactionType.MONEY_TRANSFER);
    }
}
