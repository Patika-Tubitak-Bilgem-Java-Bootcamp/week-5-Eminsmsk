package com.example.onlinebanksystem.common.request;

import com.example.onlinebanksystem.common.transaction.Transaction;
import com.example.onlinebanksystem.common.transaction.TransactionType;

public class PayCreditCartDebtRequest extends Transaction {

    public PayCreditCartDebtRequest(String senderTCNo, double amount) {
        super(senderTCNo, senderTCNo, amount, TransactionType.CREDIT_CARD);
    }
}
