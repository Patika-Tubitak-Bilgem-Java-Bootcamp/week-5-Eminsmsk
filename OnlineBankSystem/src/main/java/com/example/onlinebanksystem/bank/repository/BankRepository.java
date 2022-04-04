package com.example.onlinebanksystem.bank.repository;


import com.example.onlinebanksystem.bank.model.Bank;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
@Getter
public class BankRepository {

    private final Bank bank;

    public BankRepository() {
        bank = new Bank("MyBank",new HashSet<>());
    }
}
