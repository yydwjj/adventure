package com.yydwjj.adventure.service;

import com.yydwjj.adventure.entity.Resume;
import com.yydwjj.adventure.result.Result;

public interface ResumeService {
    /*
    * 获取所有简历
    * */
    Result getAllResumes(Long userId);

    /*
    * 保存以编辑的简历
    * */
    Result saveresume(Resume resume);

    /*
    * 获取该用户的第一份简历
    * */
    Result getLastResume(Long userId);


    /*
    * 获取要预览的简历信息
    * */
    Result showResume(Long userId);
}
