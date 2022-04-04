package com.example.onlinebanksystem.user.controller;


import com.example.onlinebanksystem.common.message.MessageResponse;
import com.example.onlinebanksystem.common.request.PayCreditCartDebtRequest;
import com.example.onlinebanksystem.common.request.PayCreditDebtRequest;
import com.example.onlinebanksystem.common.request.MoneyTransferRequest;
import com.example.onlinebanksystem.user.model.User;
import com.example.onlinebanksystem.user.model.UserDTO;
import com.example.onlinebanksystem.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public MessageResponse login(@RequestBody final UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @PutMapping("/register")
    public MessageResponse register(@RequestBody final User user) {
        return userService.register(user);
    }

    @PutMapping("/payCreditDebt")
    public MessageResponse payCreditDebt(@RequestBody final PayCreditDebtRequest request) {
        return userService.payCreditCardDebt(request.getSenderTCNo(), request.getAmount(), request.getTransactionType());
    }

    @PutMapping("/payCreditCardDebt")
    public MessageResponse payCreditCardDebt(@RequestBody final PayCreditCartDebtRequest request) {
        return userService.payCreditCardDebt(request.getSenderTCNo(), request.getAmount(), request.getTransactionType());
    }

    @PutMapping("/sendMoneyToAnotherUser")
    public MessageResponse sendMoneyToAnotherUser(@RequestBody MoneyTransferRequest request) {
        return userService.sendMoneyToAnotherUser(request.getSenderTCNo(), request.getReceiverTCNo(), request.getAmount());
    }


}
