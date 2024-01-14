package com.akrem.controller;

import com.akrem.dto.ProjectDTO;
import com.akrem.service.ProjectService;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {
    ProjectService projectService;
    UserService userService;

    @GetMapping("/create")
    public String projectCreat(Model model){
        model.addAttribute("listOfUserManager",userService.findUserByRole(2L));
        model.addAttribute("project" , new ProjectDTO());
        model.addAttribute("projectList" , projectService.listAllProjectDetails());


        return "/project/create";
    }
    @PostMapping("/create")
    public String projectPost(@ModelAttribute("project") ProjectDTO projectDTO){
        projectService.save(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String projectUpdate(@PathVariable("projectCode") String projectCode, Model model){
        model.addAttribute("listOfUserManager",userService.findUserByRole(2L));
        model.addAttribute("project" , projectService.findById(projectCode));
        model.addAttribute("projectList" , projectService.listAllProjectDetails());


        return "project/update";
    }
    @PostMapping("/update")
    public String projectUpdate2(@ModelAttribute("project") ProjectDTO projectDTO){

        projectService.updateProject(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String delete(@PathVariable("projectCode") String projectCode){
        projectService.deletedById(projectCode);

        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String complete(@PathVariable("projectCode") String projectCode){
       projectService.complete(projectCode);

        return "redirect:/project/create";
    }


}
