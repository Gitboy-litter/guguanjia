package com.chen.controller;

import com.chen.entity.AppVersion;
import com.chen.entity.Qualification;
import com.chen.entity.QualificationCondition;
import com.chen.entity.Result;
import com.chen.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.controller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/24 10:52
 * @Version: 1.0
 */
@RestController
@RequestMapping("manager/qualification")
public class QualificationController {
    @Autowired
    private QualificationService qualificationService;

    //    @RequestMapping("index.html")
//    public ModelAndView toDemand() {
//        return new ModelAndView("/demand/index.html");
//    }
//    @RequestMapping("toDetail")
//    public ModelAndView toDetail() {
//        return new ModelAndView("/demand/detail.html");
//    }
    @RequestMapping("getQualificationAll/{pageNum}/{pageSize}")
    public Result getQualificationAll(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, QualificationCondition qualificationCondition) {
        return new Result(qualificationService.selectAllPage(pageNum, pageSize, qualificationCondition));
    }

    //    @RequestMapping(value = "deleteQualificationById",method = RequestMethod.POST)
//    public Result deleteQualificationById(@RequestBody Integer id) {
//        return new Result(qualificationService.deleteByPrimaryKey(id));
//    }
    @RequestMapping("toUpdate")
    public ModelAndView toUpdate() {
        return new ModelAndView("/qualification/update.html");
    }

    @RequestMapping(value = "updateQualificationById", method = RequestMethod.POST)
    public Result updateQualificationById(@RequestBody Qualification qualification) {
        return new Result(qualificationService.updateByPrimaryKeySelective(qualification));
    }
}
