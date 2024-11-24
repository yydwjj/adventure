package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.JobPost;
import com.yydwjj.adventure.result.Result;

import java.util.List;

public interface JobService {

    Result<Integer> add(List<JobPost> job);


}
