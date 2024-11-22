package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.Resume;
import com.yydwjj.adventure.mapper.ResumeMapper;
import com.yydwjj.adventure.result.Result;
import com.yydwjj.adventure.service.Impl.ResumeServicelmpl;
import com.yydwjj.adventure.service.ResumeService;
import com.yydwjj.adventure.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


//创建Controller类并注入依赖
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    ResumeMapper resumeMapper;
    @Autowired
    ResumeService resumeservice;
    @Autowired
    JwtHelper jwtHelper;


    // 获取所有简历信息的接口
    @RequestMapping (value = "allResumes")
    public Result getResumes(@RequestHeader String token) {
        Long UserId = jwtHelper.getUserId(token);
        return resumeservice.getAllResumes(UserId);
    }

    // 保存简历信息的接口（对应前端表单提交保存操作）
    @RequestMapping(value="save",method=RequestMethod.PUT)
    public Result saveResume(@RequestBody Resume resume,@RequestHeader String token) {
        Long userId = jwtHelper.getUserId(token);
        resume.setUserId(userId);
        resume.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        resume.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return resumeservice.saveresume(resume);
    }

    @RequestMapping(value = "lastInfo")
    public Result getFirstResume(@RequestHeader String token){
        Long userId = jwtHelper.getUserId(token);

        return resumeservice.getLastResume(userId);
    }

    @RequestMapping(value = "showResume")
    public Result showResume(@RequestHeader String token){
        Long userId = jwtHelper.getUserId(token);

        return resumeservice.showResume(userId);
    }
//    // 根据ID获取单份简历信息的接口
//    @GetMapping("/{id}")
//    public ResponseEntity<Resume> getResumeById(@PathVariable("id") Long id) {
//        Optional<Resume> resumeOptional = resumeMapper.findById(id);
//        if (resumeOptional.isPresent()) {
//            return new ResponseEntity<>(resumeOptional.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//     // 更新简历信息的接口
//    @PutMapping("/{id}")
//    public ResponseEntity<Resume> updateResume(@PathVariable("id") Long id, @RequestBody Resume resume) {
//        Optional<Resume> existingResumeOptional = resumeRepository.findById(id);
//        if (existingResumeOptional.isPresent()) {
//            Resume existingResume = existingResumeOptional.get();
//            // 这里可以根据实际需求更新具体的字段，示例简单更新全部字段
//            existingResume.setName(resume.getName());
//            existingResume.setGender(resume.getGender());
//            // 依次更新其他字段（根据Resume实体类的实际属性来操作）
//            Resume updatedResume = resumeRepository.save(existingResume);
//            return new ResponseEntity<>(updatedResume, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // 删除简历信息的接口
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteResume(@PathVariable("id") Long id) {
//        Optional<Resume> resumeOptional = resumeRepository.findById(id);
//        if (resumeOptional.isPresent()) {
//            resumeRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

}