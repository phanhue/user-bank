package com.example.userbank.demo.Services;

import com.example.userbank.demo.dao.models.Bank;
import com.example.userbank.demo.dao.models.User;
import com.example.userbank.demo.dto.BankDTO;
import com.example.userbank.demo.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserBankService  {
    List<BankDTO> listbank();
    List<UserDTO> listuser();
    void createBank(BankDTO bankDTO);
    void createUser(UserDTO userDTO);
    void updateBank(BankDTO bankDTO);
    void updateUser(UserDTO userDTO);
    void deleteBank(long id);
    void deleteUser(long id);
}
