package com.yydwjj.adventure.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yydwjj.adventure.entity.Resume;
import com.yydwjj.adventure.mapper.ResumeMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public Result getResumeList() {
        List<Resume> list = resumeMapper.getResumeList();
        return Result.ok(list);
    }
}