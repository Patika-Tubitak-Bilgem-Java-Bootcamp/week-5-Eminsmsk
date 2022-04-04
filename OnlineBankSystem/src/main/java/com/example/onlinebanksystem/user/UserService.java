package com.example.onlinebanksystem.user;

import com.example.onlinebanksystem.common.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public MessageResponse register(User user) {

        return null;
    }


    public MessageResponse payCreditCardDebt(String tcNo, double paymentAmount) {
        return null;

    }

    public MessageResponse sendMoneyToAnotherUser(String senderTCNo, String receiverTCNo, double amount) {
        return null;
    }

    public MessageResponse login(User user) {
        return null;
    }
}
