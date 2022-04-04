package com.example.onlinebanksystem.common;

public class MoneyTransferRequest extends Transaction{

    public MoneyTransferRequest(String senderTCNo, String receiverTCNo, double amount) {
        super(senderTCNo, receiverTCNo, amount, TransactionType.MONEY_TRANSFER);
    }
}
