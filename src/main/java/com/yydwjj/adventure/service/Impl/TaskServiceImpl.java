package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Task;
import com.yydwjj.adventure.mapper.TaskMapper;
import com.yydwjj.adventure.model.TaskInfo;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.result.ResultCodeEnum;
import com.yydwjj.adventure.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public Result postTask(Task task) {
        int result = taskMapper.addTask(task);
        if (result == 1) {
            return Result.ok(result);
        }
        return Result.build(null,506,"add task error");
    }

    @Override
    public Result getTask(int id) {
        Task result = taskMapper.getTaskById(id);
        if (result == null) {
            return Result.build(null,506,"get task error");
        }
        return Result.ok(result);
    }

    @Override
    public Result getAllTasks() {
        List<Task> tasks = taskMapper.getAllTasks();
        return Result.ok(tasks);
    }

    @Override
    public Result findTasksByCategoryId(int categoryId) {
        List<Task> tasksByCategory = taskMapper.getTasksByCategoryId(categoryId);
        return Result.ok(tasksByCategory);
    }

    @Override
    public Result findTasksByLevelId(int levelId) {
        List<Task> tasksByLevel = taskMapper.getTasksByLevelId(levelId);
        return Result.ok(tasksByLevel);
    }

    @Override
    public Result searchTasks(String keyword) {
        List<Task> tasks = taskMapper.findTask(keyword);
        if(tasks==null|| tasks.isEmpty()){
            return Result.build(null,506,"search task error");
        }
        return Result.ok(tasks);
    }

    @Override
    public Result getTaskInfo(int id) {
        List<TaskInfo> taskInfosList = taskMapper.findTaskInfoById(id);
        if(taskInfosList==null|| taskInfosList.isEmpty()){
            return Result.build(null,506,"get task info error");
        }
        return Result.ok(taskInfosList);
    }
}
