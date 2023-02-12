package com.akrem.controller;

import com.akrem.dto.UserDTO;
import com.akrem.service.RoleService;
import com.akrem.service.UserService;
import com.akrem.service.impl.RoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final RoleService roleService;
    private final UserService userService;



    @GetMapping("/create")
    public String userCreate(Model model){
        model.addAttribute("user" , new UserDTO());
        model.addAttribute("roles" , roleService.findAll());
        model.addAttribute("users" , userService.findAll());


        return "/user/create";
    }
    @PostMapping("/create")
    public String insertUser( @ModelAttribute("user") UserDTO userDTO, Model model){
        userService.save(userDTO);


        return "redirect:/user/create";
    }


    @GetMapping ("/update/{userName}")
    public String editUser(@PathVariable("userName") String userName ,Model model ){
        model.addAttribute("user" , userService.findById(userName));




        return "/user/update";
    }
    @PostMapping ("/update")
    public String updateDone( @ModelAttribute("user") UserDTO userDTO){
         userService.updateById(userDTO.getUserName(),userDTO);
         System.out.println(userDTO);

        return "redirect:/user/create";
    }



}
