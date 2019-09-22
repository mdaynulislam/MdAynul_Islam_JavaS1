package com.trilogyed.tasker.daoTest;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception{
        //deleting the task in the database
        List<Task> taskList = taskerDao.getAllTasks();
        for(Task ts: taskList){
            taskerDao.deleteTask(ts.getId());
        }
    }

    @Test
    public void createGetDeleteTask(){
        //without the id because it's PK

        Task task = new Task();

        task.setDescription("do this");
        task.setCreateDate(LocalDate.of(1988,02,02));
        task.setDueDate(LocalDate.of(1999,02,02));
        task.setCategory("category1");
    }

    @Test
    public void getAllTasks(){

        //populating the first Task

        Task task = new Task();

        task.setDescription("do this");
        task.setCreateDate(LocalDate.of(1988,02,02));
        task.setDueDate(LocalDate.of(1999,02,02));
        task.setCategory("category1");

        taskerDao.createTask(task); //adding the first task

        //populating the second task

        task=new Task();

        task.setDescription("do this again");
        task.setCreateDate(LocalDate.of(1988,02,02));
        task.setDueDate(LocalDate.of(1999,02,02));
        task.setCategory("category2");

        taskerDao.createTask(task);

        //passing all the console in a List

        List<Task> taskList = taskerDao.getAllTasks();

        //comparing the List of task which should be 2 in size

        assertEquals(taskList.size(),2);

    }

    @Test
    public void updateTask(){

        //populating the task
        Task task = new Task();

        task.setDescription("do this");
        task.setCreateDate(LocalDate.of(1988,02,02));
        task.setDueDate(LocalDate.of(1999,02,02));
        task.setCategory("category1");

        task= taskerDao.createTask(task);

        task.setDescription("do this Updated");
        task.setCreateDate(LocalDate.of(1988,02,02));
        task.setDueDate(LocalDate.of(1999,02,02));
        task.setCategory("category Updated");

        taskerDao.updateTask(task);

        Task task1 = taskerDao.getTask(task.getId()); //adding the updated task in task1
        assertEquals(task,task1);

    }

    @Test
    public void getTaskByCategory(){

        //populating the first Task

        Task task = new Task();

        task.setDescription("do this");
        task.setCreateDate(LocalDate.of(1988,02,02));
        task.setDueDate(LocalDate.of(1999,02,02));
        task.setCategory("category1");

        taskerDao.createTask(task); //adding the first task

        //populating the second task

        task=new Task();

        task.setDescription("do this again");
        task.setCreateDate(LocalDate.of(1988,02,02));
        task.setDueDate(LocalDate.of(1999,02,02));
        task.setCategory("category2");

        taskerDao.createTask(task);

        //passing the 2 task in a list
        List<Task> byCategory= taskerDao.getTasksByCategory("category1");
        assertEquals(1,byCategory.size());

        byCategory=taskerDao.getTasksByCategory("Fake category");
        assertEquals(0,byCategory.size());

    }
}
