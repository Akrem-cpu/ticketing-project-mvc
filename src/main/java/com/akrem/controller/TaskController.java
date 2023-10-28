//package com.akrem.controller;
//
//import com.akrem.dto.ProjectDTO;
//import com.akrem.dto.TaskDTO;
//import com.akrem.dto.UserDTO;
//import com.akrem.service.ProjectService;
//import com.akrem.service.TaskService;
//import com.akrem.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Controller
//@RequestMapping("task")
//@AllArgsConstructor
//public class TaskController {
//
//  ProjectService projectService;
//  UserService userServices;
//  TaskService taskService;
//
//
//    @GetMapping("create")
//    public String taskCreate(Model model){
//
//        model.addAttribute("projectList", projectService.findAll());
//        List<UserDTO> collect = userServices.findAll().stream().filter(p -> p.getRoleDTO().getId().equals(3L)).collect(Collectors.toList());
//        model.addAttribute("userList", collect);
//        model.addAttribute("taskList", taskService.findAll());
//        model.addAttribute("task", new TaskDTO());
//
//
//
//
//        return "task/create";
//    }
//    @PostMapping("create")
//    public String taskCreate2(@ModelAttribute("task") TaskDTO taskDTO){
//        System.out.println(taskDTO);
//        taskService.save(taskDTO);
//
//
//        return "redirect:/task/create";
//    }
//
//    @GetMapping("update/{id}")
//    public String taskUpdate(@PathVariable("id")Long id, Model model){
//
//        model.addAttribute("projectList", projectService.findAll());
//        model.addAttribute("userList", userServices.findAll());
//        model.addAttribute("taskList", taskService.findAll());
//        model.addAttribute("task", taskService.findById(id));
//
//
//        return "task/update";
//    }
//// bind id here as long as the name is the same
////    @PostMapping("update/{id}")
////    public String taskUpdate2(@PathVariable("id") Long id , TaskDTO taskDTO){
////        taskDTO.setId(id);
////        taskService.updateById(taskDTO);
////
////        return "redirect:/task/create";
////    }
//    @PostMapping("update/{id}")
//    public String taskUpdate2(TaskDTO taskDTO){
//        taskService.updateById(taskDTO);
//        return "redirect:/task/create";
//    }
//
//
//    @GetMapping("delete/{id}")
//    public String taskDelete(@PathVariable("id") Long id){
//        taskService.deleteById(id);
//
//        return "redirect:/task/create";
//    }
//
//
//    @GetMapping("project-status")
//    public String pendingTasks(Model model){
//        UserDTO manager = userServices.findById("john@cydeo.com");
//        List<ProjectDTO> countedListOfProjectDTO = projectService.getCountedListOfProjectDTO(manager);
//        System.out.println(countedListOfProjectDTO);
//        model.addAttribute("projectsList",countedListOfProjectDTO);
//
//        System.out.println("hello");
//        return "/manager/project-status";
//    }
//
//
//
//}
