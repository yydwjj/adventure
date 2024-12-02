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

    // 获取我的所有简历
    @RequestMapping (value = "myResume")
    public Result getResumes(@RequestHeader String token) {
        Long UserId = jwtHelper.getUserId(token);
        return resumeService.getMyResumes(UserId);
    }

    // 新增简历信息
    @PostMapping(value="create")
    public Result saveResume(@RequestBody Resume resume, @RequestHeader String token) {
        Long userId = jwtHelper.getUserId(token);
        resume.setUserId(userId);
        resume.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        resume.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return resumeService.createresume(resume);
    }

    //修改编辑简历
    @PutMapping ("editResume/{id}")
    public Result EditResume(@PathVariable int id,@RequestBody Resume resume) {

        resume.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return resumeService.editresume(resume);
    }

    //假删除简历
    @PutMapping ("deleteResume/{id}")
    public Result DeleteResume(@PathVariable int id) {
        Resume resume = new Resume();
        resume.setResumeId(id);
        resume.setDeletedAt(new Timestamp(System.currentTimeMillis()));
        return resumeService.deleteresume(resume);
    }

    // 根据ID获取单份简历信息的接口
    @GetMapping("info/{id}")
    public Result getResumeById(@PathVariable int id ) {
        Result result = resumeService.showResumeById(id);
        return result;
    }

    //预览
    @RequestMapping(value = "showResume")
    public Result showResume(@RequestHeader String token){
        Long userId = jwtHelper.getUserId(token);
        return resumeService.showResume(userId);
    }

}