package com.example.onlinebanksystem.user.model;

import com.example.onlinebanksystem.common.message.MessageResponse;
import com.example.onlinebanksystem.common.message.MessageType;
import com.example.onlinebanksystem.common.transaction.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String birthYear;
    private String password;
    private String TCNo;
    private double balance;
    private double creditCardDebt;
    private double creditDebt;

    public boolean isPasswordValid(){
        return !password.contains(birthYear);
    }

    public MessageResponse payDebt(double amount, TransactionType type){
        return type.equals(TransactionType.CREDIT) ? makeTransaction(creditDebt,amount) : makeTransaction(creditCardDebt, amount);
    }

    public MessageResponse makeTransaction(double debt, Double amount){
        if(amount>debt){
            debt = 0.0;
            balance+= amount-debt;
            return new MessageResponse(MessageType.SUCCESS, "Debt is paid successfully and residual money added to balance");
        }else{
            debt-=amount;
            return new MessageResponse(MessageType.SUCCESS, "Payment is taken successfully. Remaining debt is: "+ debt);
        }
    }

    public boolean sendMoney(double amount){
        if(balance<amount)
            return false;
        else{
            balance-=amount;
            return true;
        }
    }

    public void receiveMoney(double amount){
        balance+=amount;
    }

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
