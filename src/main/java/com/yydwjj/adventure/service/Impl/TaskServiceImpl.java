package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Task;
import com.yydwjj.adventure.entity.User;
import com.yydwjj.adventure.mapper.TaskMapper;
import com.yydwjj.adventure.mapper.TeamMapper;
import com.yydwjj.adventure.mapper.TeamMemberMapper;
import com.yydwjj.adventure.model.TaskInfo;
import com.yydwjj.adventure.model.TeamInfo;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    TeamMemberMapper teamMemberMapper;


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

    /**
     * 根据用户id返回任务信息
     * 在此基础上 返回队伍的信息和人员的信息
      * @param userId 用户的ia
     * @return 任务信息，每个任务中的参与的队员
     */
    @Override
    public Result getTaskById(Long userId) {
        //根据userId获得参加的队伍
        List<Integer> teamIdList = teamMemberMapper.getUserTeamByUid(Math.toIntExact(userId));
        //根据队伍id获得参加的比赛
        List<Long> taskIdList = taskMapper.getTaskIdByTeamId(teamIdList);
        Map<String,List<User>> taskUsersMap = new HashMap<String,List<User>>();
        //根据队伍id获得每一个任务的参赛选手
        for(Integer teamId:teamIdList){
            List<User> teamMembersByTeamId = teamMapper.getTeamMembersByTeamId(teamId);
            long taskId = teamMapper.getTeamByTeamId(Long.valueOf(teamId)).getTaskId();
            taskUsersMap.put(String.valueOf(taskId),teamMembersByTeamId);
        }

        //根据比赛id获取比赛详细信息
        List<TaskInfo> tasks = taskMapper.getTaskInfosById(taskIdList);

        Map<String,Object> result = new HashMap<>();
        result.put("tasks",tasks);
        result.put("teamMembers",taskUsersMap);

        return Result.ok(result);

    }
}
