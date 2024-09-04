package com.task.task.service;

import com.task.task.entity.Task;
import java.util.List;

public interface TaskService {
    //Crear
    public Task createTask(Task task);
    //Obtener
    public List<Task> getAllTasks();
    public Task getTaskById(Long taskId);
    //Actualizar
    public Task updateTask(Long taskId, Task task);
    //Eliminar
    public Task deleteTaskById(Long taskId);
}
