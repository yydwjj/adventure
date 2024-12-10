package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.Resume;
import com.yydwjj.adventure.mapper.ResumeMapper;
import com.yydwjj.adventure.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.ResumeService;

import java.sql.Timestamp;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    ResumeMapper resumeMapper;
//    @Autowired
//    ResumeService resumeservice;
    @Autowired
    JwtHelper jwtHelper;

    @GetMapping("/list")
    public Result getResumeList() {
        return resumeService.getResumeList();
    }

    // 获取所有简历信息的接口
    @RequestMapping (value = "allResumes")
    public Result getResumes(@RequestHeader String token) {
        Long UserId = jwtHelper.getUserId(token);
        return resumeService.getAllResumes(UserId);
    }

    // 保存简历信息的接口（对应前端表单提交保存操作）
    @RequestMapping(value="save",method= RequestMethod.PUT)
    public Result saveResume(@RequestBody Resume resume, @RequestHeader String token) {
        Long userId = jwtHelper.getUserId(token);
        resume.setUserId(userId);
        resume.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        resume.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return resumeService.saveresume(resume);
    }

    @RequestMapping(value = "lastInfo")
    public Result getFirstResume(@RequestHeader String token){
        Long userId = jwtHelper.getUserId(token);

        return resumeService.getLastResume(userId);
    }

    @RequestMapping(value = "showResume")
    public Result showResume(@RequestHeader String token){
        Long userId = jwtHelper.getUserId(token);

        return resumeService.showResume(userId);
    }
    // 根据ID获取单份简历信息的接口
    @GetMapping("info/{id}")
    public Result getResumeById(@PathVariable int id ) {
        Result result = resumeService.showResumeById(id);
        return result;
    }

    @GetMapping("/search")
    public Result searchResumes(@RequestParam String keyword) {
        return resumeService.searchResumes(keyword);
    }
}