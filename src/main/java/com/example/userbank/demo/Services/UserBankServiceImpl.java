package com.example.userbank.demo.Services;

import com.example.userbank.demo.dao.models.Bank;
import com.example.userbank.demo.dao.models.User;
import com.example.userbank.demo.dao.repository.BankRepository;
import com.example.userbank.demo.dao.repository.UserRepository;
import com.example.userbank.demo.dto.BankDTO;
import com.example.userbank.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserBankServiceImpl implements UserBankService {

    private BankRepository bankRepository;
    private UserRepository userRepository;

    public UserBankServiceImpl(UserRepository userRepository, BankRepository bankRepository) {
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public List<BankDTO> listbank() {
        return null;
    }

    @Override
    public List<UserDTO> listuser() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getUserId());
            userDTO.setUserName(user.getUserName());
            userDTO.setFullName(user.getFullName());
            userDTO.setAge(user.getAge());
            userDTO.setGender(user.isGender());
            for (Bank bank : user.getBanks()) {
                BankDTO bankDTO = new BankDTO();
                bankDTO.setId(bank.getBankId());
                bankDTO.setName(bank.getBankName());
                bankDTO.setAccount(bank.getBankAccount());
                userDTO.getBanks().add(bankDTO);
            }
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }



    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setFullName(userDTO.getFullName());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        userRepository.save(user);
    }
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }



    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(userDTO.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUserName(userDTO.getUserName());
            user.setFullName(userDTO.getFullName());
            user.setAge(userDTO.getAge());
            user.setGender(userDTO.getGender());
            userRepository.save(user);
        }
    }

    @Override
    public void createBank(BankDTO bankDTO) {

    }
    @Override
    public void updateBank(BankDTO bankDTO) {

    }

    @Override
    public void deleteBank(long id) {

    }


}
