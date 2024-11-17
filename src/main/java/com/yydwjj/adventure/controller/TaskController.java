package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.TaskCategorie;
import com.yydwjj.adventure.entity.TaskLevel;
import com.yydwjj.adventure.mapper.TaskCategoryMapper;
import com.yydwjj.adventure.mapper.TaskLevelMapper;
import com.yydwjj.adventure.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 帖子相关的controller
 */
@RestController
@RequestMapping(value = "task")
public class TaskController {

    // 由于任务级别和任务分类并没有什么复杂操作，在控制层中直接调用dao层的方法
    @Autowired
    TaskLevelMapper taskLevelMapper;
    @Autowired
    TaskCategoryMapper taskCategoryMapper;


    @RequestMapping(value = "levels",method = RequestMethod.GET)
    public Result getLevels() {
        List<TaskLevel> levels = taskLevelMapper.getAll();
        return Result.ok(levels);
    }

    @RequestMapping(value = "category",method = RequestMethod.GET)
    public Result getCategory() {
        List<TaskCategorie> category = taskCategoryMapper.getAll();
        return Result.ok(category);
    }


}
