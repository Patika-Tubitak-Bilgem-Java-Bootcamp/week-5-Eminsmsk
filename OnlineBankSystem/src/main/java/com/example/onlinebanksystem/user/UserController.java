package com.example.onlinebanksystem.user;


import com.example.onlinebanksystem.common.MessageResponse;
import com.example.onlinebanksystem.common.PayCreditCartDebtRequest;
import com.example.onlinebanksystem.common.PayCreditDebtRequest;
import com.example.onlinebanksystem.common.MoneyTransferRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public MessageResponse register(@RequestBody final User user) {
       return userService.register(user);
    }

    @PostMapping
    public MessageResponse login(@RequestBody final User user) {
        return userService.login(user);
    }


    @PutMapping("/payCreditCardDebt")
    public MessageResponse payCreditCardDebt(@RequestBody final PayCreditCartDebtRequest request) {
        return userService.payCreditCardDebt(request.getSenderTCNo(), request.getAmount());
    }

    @PutMapping("/payCreditDebt")
    public MessageResponse payCreditDebt(@RequestBody final PayCreditDebtRequest request) {
        return userService.payCreditCardDebt(request.getSenderTCNo(), request.getAmount());
    }

    @PutMapping("/sendMoneyToAnotherUser")
    public MessageResponse sendMoneyToAnotherUser(@RequestBody MoneyTransferRequest request) {
        return userService.sendMoneyToAnotherUser(request.getSenderTCNo(), request.getReceiverTCNo(), request.getAmount());
    }


}
