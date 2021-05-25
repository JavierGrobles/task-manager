package com.jgr.taskmanager.controller;

import com.jgr.taskmanager.model.Task;
import com.jgr.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> findAll(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        return service.findAll(page,size);
    }

    @GetMapping(value = "/{id}")
    public Task findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task resource) {
        return service.createOrUpdate(resource);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Task update(@RequestBody Task resource) {
        return service.createOrUpdate(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
