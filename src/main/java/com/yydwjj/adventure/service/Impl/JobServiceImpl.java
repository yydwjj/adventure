package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.JobPost;
import com.yydwjj.adventure.mapper.JobPostMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobPostMapper jobPostMapper;

    @Override
    public Result<Integer> add(List<JobPost> job) {
        int result = jobPostMapper.batchInsert(job);
        if (result > 1) {
            return Result.ok(result);
        }
        return Result.build(null,506,"job not created");
    }
}
