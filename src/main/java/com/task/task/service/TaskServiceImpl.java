package com.task.task.service;

import jakarta.persistence.EntityNotFoundException;
import com.task.task.entity.Task;
import com.task.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(()->new EntityNotFoundException("No se encontro la tarea"));
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(()->new EntityNotFoundException("No se encontro la tarea"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        //Set enum (debo preguntarle al profe porque no lo encuentro la colocacion)
        existingTask.setCreatedAt(task.getCreatedAt());
        existingTask.setUpdatedAt(task.getUpdatedAt());
        System.out.println(task);
        return taskRepository.save(existingTask);
    }

    @Override
    public Task deleteTaskById(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if(optionalTask.isPresent()){
            taskRepository.deleteById(taskId);
            return optionalTask.get();
        }
        return null;
    }
}
