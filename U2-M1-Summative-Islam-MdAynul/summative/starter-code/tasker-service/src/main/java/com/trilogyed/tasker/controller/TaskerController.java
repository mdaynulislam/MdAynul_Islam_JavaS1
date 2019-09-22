package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel addTask(@RequestBody @Valid TaskViewModel taskViewModel){
        return service.newTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable(name = "id") int id){
        TaskViewModel taskViewModel= service.fetchTask(id);
        if(taskViewModel == null)
            throw new NotFoundException("Cannot find any task associated with the id "+id);
        return taskViewModel;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks(){
        return service.fetchAllTasks();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String deleteTask(@PathVariable int id) {
        service.deleteTask(id);
        return "Task Successfully deleted"; //just to give a confirmation message turning the return type as String
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String updateTask(@PathVariable (name = "id") int id, @RequestBody @Valid TaskViewModel taskViewModel){
        if(taskViewModel.getId()==0)
            taskViewModel.setId(id);
        if(id!=taskViewModel.getId()){
            throw new IllegalArgumentException("Task Id in the path must match in the Task");
        }
        service.updateTask(taskViewModel);
        return "Task Successfully updated";
    }

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(@PathVariable("category") String category){
            List<TaskViewModel> tvmList = service.fetchTasksByCategory(category);
            if (tvmList.size() == 0)
                throw new NotFoundException("Cannot find task with " + category);
            return tvmList;
        }


}
