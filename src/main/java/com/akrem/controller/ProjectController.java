//package com.akrem.controller;
//
//import com.akrem.dto.ProjectDTO;
//import com.akrem.dto.UserDTO;
//import com.akrem.enums.Status;
//import com.akrem.service.ProjectService;
//import com.akrem.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//@RequestMapping("/project")
//@AllArgsConstructor
//public class ProjectController {
//    ProjectService projectService;
//    UserService userService;
//
//    @GetMapping("/create")
//    public String projectCreat(Model model){
//        List<UserDTO> userDTOList = userService.findAll().stream().filter(p-> p.getRoleDTO().getDescription().equals("manager")).collect(Collectors.toList());
//        model.addAttribute("listOfUserManager",userDTOList);
//        model.addAttribute("project" , new ProjectDTO());
//        model.addAttribute("projectList" , projectService.findAll());
//
//
//        return "/project/create";
//    }
//    @PostMapping("/create")
//    public String projectPost(@ModelAttribute("project") ProjectDTO projectDTO){
//        projectService.save(projectDTO);
//        System.out.println(projectDTO);
//
//
//
//        return "redirect:/project/create";
//    }
//
//    @GetMapping("/update/{projectCode}")
//    public String projectUpdate(@PathVariable("projectCode") String projectCode, Model model){
//        model.addAttribute("listOfUserManager",userService.findManagers());
//        model.addAttribute("project" , projectService.findById(projectCode));
//        model.addAttribute("projectList" , projectService.findAll());
//
//
//        return "project/update";
//    }
//    @PostMapping("/update")
//    public String projectUpdate2(@ModelAttribute("project") ProjectDTO projectDTO){
//
//        projectService.updateById(projectDTO);
//
//        System.out.println(projectDTO);
//
//
//        return "redirect:/project/create";
//    }
//
//    @GetMapping("/delete/{projectCode}")
//    public String delete(@PathVariable("projectCode") String projectCode){
//        projectService.deleteById(projectCode);
//
//        return "redirect:/project/create";
//    }
//
//    @GetMapping("/complete/{projectCode}")
//    public String complete(@PathVariable("projectCode") String projectCode){
//       projectService.complete(projectCode);
//
//        return "redirect:/project/create";
//    }
//
//}
