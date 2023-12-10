package com.akrem.controller;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.TaskDTO;
import com.akrem.dto.UserDTO;
import com.akrem.service.ProjectService;
import com.akrem.service.TaskService;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("task")
@AllArgsConstructor
public class TaskController {

  ProjectService projectService;
  UserService userServices;
  TaskService taskService;


    @GetMapping("create")
    public String taskCreate(Model model){
        model.addAttribute("projectList", projectService.findAllProject());
        List<UserDTO> collect = userServices.findUserByRole(3L);
        model.addAttribute("userList", collect);
        model.addAttribute("taskList", taskService.findAllTask());
        model.addAttribute("task", new TaskDTO());

        return "task/create";
    }
    @PostMapping("create")
    public String taskCreate2(@ModelAttribute("task") TaskDTO taskDTO){
        taskService.save(taskDTO);


        return "redirect:/task/create";
    }

    @GetMapping("update/{id}")
    public String taskUpdate(@PathVariable("id")Long id, Model model){
        model.addAttribute("projectList", projectService.findAllProject());
        model.addAttribute("userList", userServices.findUserByRole(3L));
        model.addAttribute("taskList", taskService.findAllTask());
        model.addAttribute("task", taskService.findById(id));


        return "task/update";
    }
//// bind id here as long as the name is the same
    @PostMapping("update/{id}")
    public String taskUpdate2(@PathVariable("id") Long id , TaskDTO taskDTO){
        taskService.updateById(taskDTO);

        return "redirect:/task/create";
    }
//    @PostMapping("update/{id}")
//    public String taskUpdate2(TaskDTO taskDTO){
//        taskService.updateById(taskDTO);
//        return "redirect:/task/create";
//    }
//

    @GetMapping("delete/{id}")
    public String taskDelete(@PathVariable("id") Long id){
        taskService.deleteById(id);

        return "redirect:/task/create";
    }


    @GetMapping("project-status")
    public String pendingTasks(Model model){

        List<ProjectDTO> countedListOfProjectDTO = projectService.listAllProjectDetails();
        model.addAttribute("projectsList",countedListOfProjectDTO);
        return "/manager/project-status";
    }



}
