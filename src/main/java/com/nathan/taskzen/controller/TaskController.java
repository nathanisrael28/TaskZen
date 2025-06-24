package com.nathan.taskzen.controller;

import com.nathan.taskzen.entity.TaskEntity;
import com.nathan.taskzen.enums.Status;
import com.nathan.taskzen.model.TaskDto;
import com.nathan.taskzen.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/taskDto")
    public ResponseEntity<String> createTask(@RequestBody @Valid TaskDto task){

       return new ResponseEntity<>(taskService.createTask(task),HttpStatus.CREATED);
// we can write like below as well
// return ResponseEntity.status(HttpStatus.CREATED).body("Task created!");

    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTask(){

        List<TaskDto> tasks =taskService.getAllTask();
    return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

/*    //V1
    // Here we use this URL request since we are passing as Request Parameter
    // http://localhost:8080/api/task/id?id=1
    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTask(@RequestParam Long id){

        return new ResponseEntity<>(taskService.getTask(id),HttpStatus.OK);
    }*/

    //V2
    // For this we can simply send id as path Variable http://localhost:8080/api/task/1
    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id){

        return new ResponseEntity<>(taskService.getTask(id),HttpStatus.OK);
    }

    @PutMapping("/task/")
    public ResponseEntity<String>  updateTask(@RequestBody @Valid TaskDto taskDto){

        return new ResponseEntity<>(taskService.updateTask(taskDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<String>  deleteTask(@PathVariable Long id){

        return new ResponseEntity<>(taskService.deleteTask(id),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/task/{id}/status")
    ResponseEntity<String>  updateStatus(@PathVariable Long id, @RequestParam Status status) {

        return new ResponseEntity<>(taskService.updateStatus(id,status), HttpStatus.ACCEPTED);

    }



}
