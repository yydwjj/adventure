package com.yydwjj.adventure.service.Impl;

import com.yydwjj.adventure.entity.Resume;
import com.yydwjj.adventure.mapper.ResumeMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServicelmpl implements ResumeService {
    @Autowired
    ResumeMapper resumemapper;

//    寻找该用户的简历
    @Override
    public Result getAllResumes(Long userId) {
        List<Resume> resumes = resumemapper.findAllResumes(userId);
        if (resumes.isEmpty()) {
            return Result.build(null,507,"无已有简历");
        }
        return Result.ok(resumes);
    }

//    保存已编辑的简历
    @Override
    public Result saveresume(Resume resume) {
        int result=resumemapper.save(resume);

        if(result==1){
            return Result.ok(resume);
        }
        return Result.build(null,507,"保存失败");
    }

//    获取该用户的第一份简历
    @Override
    public Result getLastResume(Long userId) {
        Resume firstresume = resumemapper.findLastResumes(userId);
        if (firstresume==null) {
            return Result.build(null,507,"无简历");
        }
        return Result.ok(firstresume);
    }

    @Override
    public Result showResume(Long userId) {
        Resume showresume = resumemapper.showResumes(userId);
        if (showresume==null) {
            return Result.build(null,507,"无简历");
        }
        return Result.ok(showresume);
    }

    @Override
    public Result showResumeById(int resumeId) {
        Resume showresume = resumemapper.showResumesById(resumeId);
        if (showresume==null) {
            return Result.build(null,507,"无简历");
        }
        return Result.ok(showresume);
    }


}
