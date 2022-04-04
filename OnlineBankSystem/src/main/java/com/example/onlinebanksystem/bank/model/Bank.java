package com.example.onlinebanksystem.bank.model;

import com.example.onlinebanksystem.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    private String name;
    private Set<User> users;

}
