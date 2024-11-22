//package com.yydwjj.adventure.controller;
//
//import com.yydwjj.adventure.entity.Task;
//import com.yydwjj.adventure.entity.TaskCategorie;
//import com.yydwjj.adventure.entity.TaskLevel;
//import com.yydwjj.adventure.mapper.TaskCategoryMapper;
//import com.yydwjj.adventure.mapper.TaskLevelMapper;
//import com.yydwjj.adventure.result.Result;
//import com.yydwjj.adventure.service.TaskService;
//import com.yydwjj.adventure.utils.JwtHelper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Timestamp;
//import java.util.List;
//
///**
// * 帖子相关的controller
// */
//@RestController
//@RequestMapping(value = "task")
//public class TaskController {
//
//    // 由于任务级别和任务分类并没有什么复杂操作，在控制层中直接调用dao层的方法
//    @Autowired
//    TaskLevelMapper taskLevelMapper;
//    @Autowired
//    TaskCategoryMapper taskCategoryMapper;
//    @Autowired
//    TaskService taskService;
//    @Autowired
//    JwtHelper jwtHelper;
//
//
////    @Autowired
////    TaskServer taskServer;
//
//
//    @RequestMapping(value = "levels",method = RequestMethod.GET)
//    public Result getLevels() {
//        List<TaskLevel> levels = taskLevelMapper.getAll();
//        return Result.ok(levels);
//    }
//
//    @RequestMapping(value = "category",method = RequestMethod.GET)
//    public Result getCategory() {
//        List<TaskCategorie> category = taskCategoryMapper.getAll();
//        return Result.ok(category);
//    }
//
//    /**
//     * 发帖的方法
//     * @param task
//     * @param token
//     * @return
//     */
//    @RequestMapping(value = "post",method = RequestMethod.POST)
//    public Result postTask(@RequestBody Task task, @RequestHeader String token) {
//        Long userId = jwtHelper.getUserId(token);
////        获取了用户id
//        task.setPublisherId(userId);
//        task.setCreatedAt(new Timestamp(System.currentTimeMillis()));
//        task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
//        return taskService.postTask(task);
//    }
//
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Result getTask(@PathVariable int id, @RequestHeader String token) {
//        Long userId = jwtHelper.getUserId(token);
//        return taskService.getTask(id);
//    }
//
//    @RequestMapping(value = "all",method = RequestMethod.GET)
//    public Result getAllTasks(){
//        return taskService.getAllTasks();
//    }
//
//    @RequestMapping(value = "c/{categoryId}",method = RequestMethod.GET)
//    public Result getTasksByCategory(@RequestParam int categoryId){
//        return taskService.findTasksByCategoryId(categoryId);
//    }
//
//    @RequestMapping(value = "l/{levelId}",method = RequestMethod.GET)
//    public Result getTasksByLevel(@RequestParam int levelId){
//        return taskService.findTasksByLevelId(levelId);
//    }
//
//    @RequestMapping(value = "search/{keyword}",method = RequestMethod.GET)
//    public Result getTasksByKeyword(@PathVariable String keyword){
//        return taskService.searchTasks(keyword);
//    }
//
//
//    @GetMapping(value = "info/{id}")
//    public Result getTaskInfoById(@PathVariable int id){
//        Result result = taskService.getTaskInfo(id);
//        return result;
//    }
//}
