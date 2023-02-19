package com.akrem.controller;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.UserDTO;
import com.akrem.service.ProjectService;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("project")
@AllArgsConstructor
public class ProjectController {
    ProjectService projectService;
    UserService userService;

    @GetMapping("create")
    public String projectCreat(Model model){
        List<UserDTO> userDTOList = userService.findAll().stream().filter(p-> p.getRoleDTO().getDescription().equals("manager")).collect(Collectors.toList());
        model.addAttribute("listOfUserManager",userDTOList);
        model.addAttribute("project" , new ProjectDTO());


        return "project/create";
    }



}
