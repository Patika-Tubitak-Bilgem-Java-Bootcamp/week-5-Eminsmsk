package com.example.onlinebanksystem.user.service;

import com.example.onlinebanksystem.bank.repository.BankRepository;
import com.example.onlinebanksystem.common.message.MessageResponse;
import com.example.onlinebanksystem.common.message.MessageType;
import com.example.onlinebanksystem.common.transaction.TransactionType;
import com.example.onlinebanksystem.user.model.User;
import com.example.onlinebanksystem.user.model.UserDTO;
import com.example.onlinebanksystem.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final BankRepository bankRepository;
    private final UserRepository userRepository;

    public UserService(BankRepository bankRepository, UserRepository userRepository) {
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
    }

    public MessageResponse login(UserDTO userDTO) {
        Optional<User> attachedUser = userRepository.getUser(bankRepository, userDTO.toUser());
        if (attachedUser.isPresent() && attachedUser.get().getPassword().equals(userDTO.toUser().getPassword())) {
            return new MessageResponse(MessageType.SUCCESS, "Successfully logged in");
        } else {
            return new MessageResponse(MessageType.ERROR, "Invalid TC or Password");
        }
    }

    public MessageResponse register(User user) {
        if (bankRepository.getBank().getUsers().contains(user))
            return new MessageResponse(MessageType.ERROR, "Already registered");
        else {
            if (user.isPasswordValid()) {
                bankRepository.getBank().getUsers().add(user);
                return new MessageResponse(MessageType.SUCCESS, "Successfully registered");
            } else {
                return new MessageResponse(MessageType.SUCCESS, "Birth year cannot be in your password");
            }
        }
    }

    //User can pay his/her credit or credit card debt via this method.
    public MessageResponse payCreditCardDebt(String tcNo, double paymentAmount, TransactionType transactionType) {
        Optional<User> attachedUser = userRepository.getUser(bankRepository, new UserDTO(tcNo).toUser());
        if (attachedUser.isPresent()) {
            return attachedUser.get().payDebt(paymentAmount, transactionType);
        } else {
            return new MessageResponse(MessageType.ERROR, "An error occurred");
        }
    }

    public MessageResponse sendMoneyToAnotherUser(String senderTCNo, String receiverTCNo, double amount) {
        Optional<User> attachedSenderUser = userRepository.getUser(bankRepository, new UserDTO(senderTCNo).toUser());
        Optional<User> attachedReceiverUser = userRepository.getUser(bankRepository, new UserDTO(receiverTCNo).toUser());
        if(attachedSenderUser.isPresent() && attachedReceiverUser.isPresent()){
            if(attachedSenderUser.get().sendMoney(amount)){
                attachedReceiverUser.get().receiveMoney(amount);
                return new MessageResponse(MessageType.SUCCESS, "Transaction is done successfully");
            }else{
                return new MessageResponse(MessageType.ERROR, "You do not enough money to make this transaction");
            }
        }else{
            return new MessageResponse(MessageType.ERROR, "An error occurred");
        }
    }

}
