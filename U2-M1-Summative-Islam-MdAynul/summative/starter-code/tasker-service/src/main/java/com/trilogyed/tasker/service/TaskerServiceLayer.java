package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

     TaskerDao dao;
     AdClient adClient; // Feign interface to access the ad server

     //constructor
    @Autowired
    public TaskerServiceLayer(TaskerDao dao, AdClient adClient) {
        this.dao = dao;
        this.adClient = adClient;
    }

    //Save Task
    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();

        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        return buildTaskViewModel(task);

    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        if (task == null) {
            return null;
        } else {
            return buildTaskViewModel(task);
        }

    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task>taskList= dao.getAllTasks();
        List<TaskViewModel> taskViewModelList= new ArrayList<>();

        for(Task task: taskList){
            TaskViewModel tvm= buildTaskViewModel(task);
            taskViewModelList.add(tvm);
        }
        return taskViewModelList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tList = dao.getTasksByCategory(category);
        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task task : tList) {
            tvmList.add(buildTaskViewModel(task));
        }
            return tvmList;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        dao.updateTask(task);

    }

    private TaskViewModel buildTaskViewModel(Task task) {

        if(task==null) return null;
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(adClient.getAd());

        return tvm;
    }
}
