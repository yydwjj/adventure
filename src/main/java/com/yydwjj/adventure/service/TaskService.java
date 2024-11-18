package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Task;
import com.yydwjj.adventure.result.Result;

import java.util.List;

public interface TaskService {

    /**
     * 发帖方法
     * @param task 帖子信息，不包括id和isExist
     * @return 创建结果
     */
    Result postTask (Task task);

    /**
     * 根据id获得指定任务
     * @param id 任务id
     * @return 任务表中的信息
     */
    Result getTask (int id);

    /**
     * 获得所有任务
     * @return 全部任务的列表
     */
    Result getAllTasks();

    /**
     * 获取某一分类下的所有任务
     * @param categoryId    分类id
     * @return 任务列表
     */
    Result findTasksByCategoryId (int categoryId);

    /**
     * 获取某一级别下的所有任务
     * @param levelId   级别id
     * @return  任务列表
     */
    Result findTasksByLevelId (int levelId);

    /**
     * 在任务名和任务信息中模糊查询
     * @param keyword   关键字
     * @return  任务列表
     */
    Result searchTasks(String keyword);
}
