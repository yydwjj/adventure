package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.JobPost;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "job")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping(value = "create")
    public Result<Integer> create(@RequestBody List<JobPost> jobs) {
        // 获取当前时间
        Timestamp now = new Timestamp(System.currentTimeMillis());

        // 设置每个 JobPost 的时间戳
        for (JobPost job : jobs) {
            job.setCreatedAt(now);
            job.setUpdatedAt(now);
        }

        // 调用服务层批量插入

        return jobService.add(jobs);
    }

    @GetMapping(value = "info/{jid}")
    public Result<JobPost> info(@PathVariable("jid") int jid) {
         return jobService.get(jid);
    }
}
