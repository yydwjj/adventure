package com.yydwjj.adventure.controller;

import com.yydwjj.adventure.entity.School;
import com.yydwjj.adventure.mapper.SchoolMapper;
import com.yydwjj.adventure.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolController {
    @Autowired
    SchoolMapper schoolMapper;
    @GetMapping("/")
    public Result index() {
        List<School> schoolList = schoolMapper.getAllSchool();
        return Result.ok(schoolList);
    }
}
