package com.trilogyed.tasker.serviceTest;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class TaskerServiceTest {

    TaskerDao taskerDao;
    AdClient client;

    //service Layer
    TaskerServiceLayer service;

    @Before
    public void setUp()throws Exception{

        setUpTaskDaoMock();
        setUpAdClientDaoMock();
        service= new TaskerServiceLayer(taskerDao,client);
    }

    @Test
    public void saveTask(){

        TaskViewModel taskViewModel = new TaskViewModel();

        //adding the first Task from the save Task without the id

        taskViewModel.setDescription("Task 1");
        taskViewModel.setCreateDate(LocalDate.of(2019,02,02));
        taskViewModel.setDueDate(LocalDate.of(2019,03,03));
        taskViewModel.setCategory("First Task");

        taskViewModel= service.newTask(taskViewModel);

        TaskViewModel fromService=service.fetchTask(taskViewModel.getId());
        assertEquals(taskViewModel,fromService);

    }

    @Test
    public void findTask(){

        //Taking the first task from TaskDaoMock

        Task task = new Task();

        task.setId(1);
        task.setDescription("Task 1");
        task.setCreateDate(LocalDate.of(2019,02,02));
        task.setDueDate(LocalDate.of(2019,03,03));
        task.setCategory("First Task");

        //add the task into the TaskViewModel
        TaskViewModel taskViewModel = service.fetchTask(1);

        //create another task object and passing the viewModel to compare
        Task task1= new Task();

        task1.setId(taskViewModel.getId());
        task1.setDescription(taskViewModel.getDescription());
        task1.setCreateDate(taskViewModel.getCreateDate());
        task1.setDueDate(taskViewModel.getDueDate());
        task1.setCategory(taskViewModel.getCategory());

        assertEquals(task1,task);

    }

    @Test
    public void findAllTasks(){

        //getting all the task from the TaskViewModel
        List<TaskViewModel> fromService= service.fetchAllTasks();
        assertEquals(1,fromService.size());
    }

    @Test
    public void updateTask(){
        TaskViewModel taskViewUpdate = new TaskViewModel();
        //taking the task from the update chunk

        Task updateTask = new Task();

        updateTask.setId(2);
        updateTask.setDescription("Task 1 Updated");
        updateTask.setCreateDate(LocalDate.of(2019,02,02));
        updateTask.setDueDate(LocalDate.of(2019,03,03));
        updateTask.setCategory("First Task Updated");

        //passing into the TaskViewModel

        taskViewUpdate.setId(updateTask.getId());
        taskViewUpdate.setDescription(updateTask.getDescription());
        taskViewUpdate.setCreateDate(updateTask.getCreateDate());
        taskViewUpdate.setDueDate(updateTask.getDueDate());
        taskViewUpdate.setCategory(updateTask.getCategory());

        service.updateTask(taskViewUpdate);
        //finding the task we just updated
        TaskViewModel taskViewModel = service.fetchTask(2);

        //passing the updated Task into taskAfterUpdate object
        Task taskAfterUpdate= new Task();

        taskAfterUpdate.setId(taskViewModel.getId());
        taskAfterUpdate.setDescription(taskViewModel.getDescription());
        taskAfterUpdate.setCreateDate(taskViewModel.getCreateDate());
        taskAfterUpdate.setDueDate(taskViewModel.getDueDate());
        taskAfterUpdate.setCategory(taskViewModel.getCategory());

        //comparing both task
        assertEquals(taskAfterUpdate,updateTask);

    }

    @Test
    public void removeTask(){
        //taking the id from remove task which is 3
        service.deleteTask(3);

        TaskViewModel taskViewModel = service.fetchTask(3);
        assertNull(taskViewModel);
    }

    @Test
    public void getTaskByCategory(){
        TaskViewModel taskViewModel = new TaskViewModel();

        //adding the first task from the Save task Dao without the id
        taskViewModel.setDescription("Task 1");
        taskViewModel.setCreateDate(LocalDate.of(2019,02,02));
        taskViewModel.setDueDate(LocalDate.of(2019,03,03));
        taskViewModel.setCategory("First Task");

        taskViewModel= service.newTask(taskViewModel);

        List<TaskViewModel> byCategory= service.fetchTasksByCategory("First Task");

        assertEquals(1,byCategory.size());

        byCategory=service.fetchTasksByCategory("Fake Category");
        assertEquals(0,byCategory.size());
    }




    /********************************** DAO MOCK *****************************************/

    private void setUpAdClientDaoMock() { // for the advertisement
        client = mock(AdClient.class);
        doReturn("chill out").when(client).getAd();
    }
    private void setUpTaskDaoMock(){

        //creating the mock object for TaskDaoJdbcTemplateImpl
        taskerDao= mock(TaskerDaoJdbcTemplateImpl.class);

        //Mock add task

        Task task = new Task();

        task.setId(1);
        task.setDescription("Task 1");
        task.setCreateDate(LocalDate.of(2019,02,02));
        task.setDueDate(LocalDate.of(2019,03,03));
        task.setCategory("First Task");


        //creating another Task object without the id
        Task task1 = new Task();

        task1.setDescription("Task 1");
        task1.setCreateDate(LocalDate.of(2019,02,02));
        task1.setDueDate(LocalDate.of(2019,03,03));
        task1.setCategory("First Task");

        doReturn(task).when(taskerDao).createTask(task1);

        //Mock get Task
        doReturn(task).when(taskerDao).getTask(1);

        //Mock the get all Task
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(taskList).when(taskerDao).getAllTasks();

        //Mock the update Task
        Task updateTask = new Task();

        updateTask.setId(2);
        updateTask.setDescription("Task 1 Updated");
        updateTask.setCreateDate(LocalDate.of(2019,02,02));
        updateTask.setDueDate(LocalDate.of(2019,03,03));
        updateTask.setCategory("First Task Updated");

        doNothing().when(taskerDao).updateTask(updateTask);
        doReturn(updateTask).when(taskerDao).getTask(2);

        //Mock the remove Task

        Task deleteTask= new Task();

        deleteTask.setId(3);
        deleteTask.setDescription("Task 1 deleted");
        deleteTask.setCreateDate(LocalDate.of(2019,02,02));
        deleteTask.setDueDate(LocalDate.of(2019,03,03));
        deleteTask.setCategory("First Task deleted");

        doNothing().when(taskerDao).deleteTask(3);
        doReturn(null).when(taskerDao).getTask(3);

        //Mock the get Task by Category
        doReturn(taskList).when(taskerDao).getTasksByCategory("First Task");

    }

}
