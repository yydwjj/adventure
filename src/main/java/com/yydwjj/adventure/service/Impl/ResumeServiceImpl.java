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

    //    寻找该用户的所有未被删除的简历
    @Override
    public Result getMyResumes(Long userId) {
        List<Resume> resumes = resumeMapper.findAllResumes(userId);
        if (resumes.isEmpty()) {
            return Result.build(null,507,"无已有简历");
        }
        return Result.ok(resumes);
    }

    //    创建简历
    @Override
    public Result createresume(Resume resume) {
        int result=resumeMapper.create(resume);

        if(result==1){
            return Result.ok(resume);
        }
        return Result.build(null,507,"创建失败");
    }

    //编辑简历
    @Override
    public Result editresume(Resume resume) {
        int result=resumeMapper.edit(resume);
        if(result==1){
            return Result.ok(resume);
        }
        return Result.build(null,507,"编辑失败");
    }
    //删除简历
    @Override
    public Result deleteresume(Resume resume) {
        int result=resumeMapper.delete(resume);
        if(result==1){
            return Result.ok(resume);
        }
        return Result.build(null,507,"删除失败");
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