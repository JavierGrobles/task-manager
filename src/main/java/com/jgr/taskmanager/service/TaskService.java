package com.jgr.taskmanager.service;

import com.jgr.taskmanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAll(Optional<Integer> page, Optional<Integer> size);
    Task createOrUpdate(Task task);
    void deleteById(Long id);
    Task findById(Long id);
}
