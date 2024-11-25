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

    //    寻找该用户的简历
    @Override
    public Result getAllResumes(Long userId) {
        List<Resume> resumes = resumeMapper.findAllResumes(userId);
        if (resumes.isEmpty()) {
            return Result.build(null,507,"无已有简历");
        }
        return Result.ok(resumes);
    }

    //    保存已编辑的简历
    @Override
    public Result saveresume(Resume resume) {
        int result=resumeMapper.save(resume);

        if(result==1){
            return Result.ok(resume);
        }
        return Result.build(null,507,"保存失败");
    }

    //    获取该用户的第一份简历
    @Override
    public Result getLastResume(Long userId) {
        Resume firstresume = resumeMapper.findLastResumes(userId);
        if (firstresume==null) {
            return Result.build(null,507,"无简历");
        }
        return Result.ok(firstresume);
    }

    @Override
    public Result showResume(Long userId) {
        Resume showresume = resumeMapper.showResumes(userId);
        if (showresume==null) {
            return Result.build(null,507,"无简历");
        }
        return Result.ok(showresume);
    }

    @Override
    public Result showResumeById(int resumeId) {
        Resume showresume = resumeMapper.showResumesById(resumeId);
        if (showresume==null) {
            return Result.build(null,507,"无简历");
        }
        return Result.ok(showresume);
    }
}