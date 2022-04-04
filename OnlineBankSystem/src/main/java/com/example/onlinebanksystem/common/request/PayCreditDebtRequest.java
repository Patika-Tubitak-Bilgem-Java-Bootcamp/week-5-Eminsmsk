package com.example.onlinebanksystem.common.request;

import com.example.onlinebanksystem.common.transaction.Transaction;
import com.example.onlinebanksystem.common.transaction.TransactionType;

public class PayCreditDebtRequest extends Transaction {

    public PayCreditDebtRequest(String senderTCNo, double amount) {
        super(senderTCNo, senderTCNo, amount, TransactionType.CREDIT);
    }
}
