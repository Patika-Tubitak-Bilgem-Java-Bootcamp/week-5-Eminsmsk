package com.example.onlinebanksystem.common;

public class PayCreditDebtRequest extends Transaction{

    public PayCreditDebtRequest(String senderTCNo, double amount) {
        super(senderTCNo, senderTCNo, amount, TransactionType.CREDIT);
    }
}
