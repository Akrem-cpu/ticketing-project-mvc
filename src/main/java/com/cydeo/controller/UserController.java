package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("/create")
    public String userCreate(Model model){
        model.addAttribute("user" , new UserDTO());
        model.addAttribute("role" , new UserDTO());

        return "user/create";
    }


}
