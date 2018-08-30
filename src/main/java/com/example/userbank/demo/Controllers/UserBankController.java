package com.example.userbank.demo.Controllers;

import com.example.userbank.demo.Services.UserBankService;
import com.example.userbank.demo.dao.models.Bank;
import com.example.userbank.demo.dao.models.User;
import com.example.userbank.demo.dto.BankDTO;
import com.example.userbank.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping(value = "/userbank")
public class UserBankController {
@Autowired
    private UserBankService userBankService;

    @GetMapping(value = "/user")
    public @ResponseBody
    List<UserDTO> getUserUser(){return userBankService.listuser(); }

    @PostMapping(value = "/user")
    public @ResponseBody String createUser(@RequestBody UserDTO userDTO){
        return userBankService.createUser(userDTO);
    }

    @PutMapping(value = "/user")
    public @ResponseBody String udpateUser(@RequestBody UserDTO userDTO){
        return userBankService.updateUser(userDTO);
    }

    @DeleteMapping(value = "/user/{id}")
    public @ResponseBody String removeUser(@PathVariable(value = "id") Long id) {
        userBankService.deleteUser(id);
        return "OK";
    }

    @GetMapping(value = "/bank")
    public @ResponseBody
    List<BankDTO> getUserBank(){return userBankService.listbank(); }


    @PostMapping(value = "/bank")
    public @ResponseBody String createBank(@RequestBody BankDTO bankDTO){
        return userBankService.createBank(bankDTO);
    }



    @PutMapping(value = "/bank")
    public @ResponseBody String udpateBank(@RequestBody BankDTO bankDTO){
        return userBankService.updateBank(bankDTO);
    }


    @DeleteMapping(value = "bank/{id}")
    public @ResponseBody String deleteUser(@PathVariable(value = "id") Long id ){
        return userBankService.deleteUser(id);
    }

}
