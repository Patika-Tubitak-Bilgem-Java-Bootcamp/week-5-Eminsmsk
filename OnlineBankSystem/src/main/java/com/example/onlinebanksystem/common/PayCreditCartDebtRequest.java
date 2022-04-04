package com.example.onlinebanksystem.common;

public class PayCreditCartDebtRequest extends Transaction{

    public PayCreditCartDebtRequest(String senderTCNo, double amount) {
        super(senderTCNo, senderTCNo, amount, TransactionType.CREDIT_CARD);
    }
}
