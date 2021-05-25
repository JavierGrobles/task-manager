package com.jgr.taskmanager.service.impl;

import com.jgr.taskmanager.model.Task;
import com.jgr.taskmanager.repository.TaskRepository;
import com.jgr.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private static final int MAX_PAGE_SIZE = 50;
    private TaskRepository taskRepository;
    @Autowired
    public void setTaskRepository(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    @Override
    public List<Task> findAll(Optional<Integer> page, Optional<Integer> size) {

        return taskRepository.findAll(PageRequest.of(page.orElse(0), size.orElse(MAX_PAGE_SIZE))).toList();

    }

    @Override
    public Task createOrUpdate(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }
}
