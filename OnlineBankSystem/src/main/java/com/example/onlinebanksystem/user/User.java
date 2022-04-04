package com.example.onlinebanksystem.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String password;
    private String TCNo;
    private double balance;
    private double creditCardDebt;
    private double creditDebt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return TCNo.equals(user.TCNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TCNo);
    }
}
