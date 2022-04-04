package com.example.onlinebanksystem.user.repository;

import com.example.onlinebanksystem.bank.repository.BankRepository;
import com.example.onlinebanksystem.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    public Optional<User> getUser(BankRepository bankRepository, User user){
        return bankRepository.getBank().getUsers().stream().filter(u -> u.equals(user)).findAny();
    }

}
