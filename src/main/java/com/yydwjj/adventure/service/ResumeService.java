package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Resume;
import com.yydwjj.adventure.result.Result;

public interface ResumeService {
    Result getResumeList();

    /*
     * 获取所有简历
     * */
    Result getMyResumes(Long userId);

    /*
     * 创建简历
     * */
    Result createresume(Resume resume);

    /*
     * 删除简历
     * */
    Result deleteresume(Resume resume);


    /*
     * 获取要预览的简历信息
     * */
    Result showResume(Long userId);

    /*
     * 通过简历ID获取信息
     * */
    Result showResumeById(int resumeId);

    /*
    *寻找他人对该用户的评价
    * */
    Result getEvaluationById(int userId);

    Result editresume(Resume resume);


}