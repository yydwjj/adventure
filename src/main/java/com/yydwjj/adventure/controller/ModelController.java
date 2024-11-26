package com.yydwjj.adventure.controller;


import com.yydwjj.adventure.entity.Task;
import com.yydwjj.adventure.entity.Team;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.Impl.ModelService;
import com.yydwjj.adventure.service.TaskService;
import com.yydwjj.adventure.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TeamService teamService;

    @PostMapping("/chat")
    public String chatCompletion(@RequestParam String model,
                                  @RequestParam String systemMessage,
                                  @RequestParam String userMessage) {
        try {
            return modelService.getChatCompletion(model, systemMessage, userMessage);
        } catch (Exception e) {
            return "调用大模型 API 时出错: " + e.getMessage();
        }
    }

    /**
     * 根据队伍id，返回推荐的岗位
     * @param teamId 队伍id
     * @return 一句建议的话，只是String
     */
    @GetMapping("/jobs")
    public String jobsSuggest(@RequestParam int teamId){
        Result<Team> teamResult = teamService.getTeam((long) teamId);
        Result taskResult = taskService.getTask((int) teamResult.getData().getTaskId());
        Task task = (Task) taskResult.getData();
        String taskName = task.getTaskName();
        String taskInfo = task.getTaskInfo();
        String userMessage = "Please recommend the team member roles needed for participating in the following competition, and include a brief description of the task:\n" +
                "- Competition Name："+taskName+"\n" +
                "- Task Description："+taskInfo;
        try {
            return modelService.getChatCompletion("deepseek-chat", "You are a helpful assistant and speak chinese and short,simple", userMessage);
        } catch (Exception e) {
            return "调用大模型 API 时出错: " + e.getMessage();
        }
    }
}
