package com.akrem.controller;

import com.akrem.dto.UserDTO;
import com.akrem.service.RoleService;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String userCreate(Model model){
        model.addAttribute("user" , new UserDTO());
        model.addAttribute("roles" , roleService.findAllRole());
        model.addAttribute("users" , userService.listAllUsers());


        return "/user/create";
    }
    @PostMapping("/create")
    public String insertUser( @ModelAttribute("user") UserDTO userDTO, Model model){
        userService.save(userDTO);


        return "redirect:/user/create";
    }


    @GetMapping ("/update/{userName}")
    public String editUser(@PathVariable("userName") String userName ,Model model ){
        model.addAttribute("user" , userService.findByUserName(userName));
        model.addAttribute("roles" , roleService.findAllRole());
        model.addAttribute("users" , userService.listAllUsers());
        return "/user/update";
    }

    @PostMapping ("/update")
    public String updateDone( @ModelAttribute("user") UserDTO userDTO){
         userService.update(userDTO);

        return "redirect:/user/create";
    }
    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable("id") String userName ){
        userService.deleteByUserName(userName);

        return "redirect:/user/create";
    }



}
