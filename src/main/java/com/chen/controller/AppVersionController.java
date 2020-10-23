package com.chen.controller;

import com.chen.entity.AppVersion;
import com.chen.entity.Result;
import com.chen.service.AppVersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.controller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/22 16:06
 * @Version: 1.0
 */
@RestController
@RequestMapping("manager/app/")
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping("/index,/index.html")
    public ModelAndView toIndex(){
        return new ModelAndView("/app/index.html");
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(){
        return new ModelAndView("/app/update.html");
    }
    @RequestMapping("toDetail")
    public ModelAndView toDetail(){
        return new ModelAndView("/app/detail.html");
    }

    @RequestMapping("getAppVersionAll")
    public Result getAppVersionAll(Integer pageNo,Integer pageSize){
        return new Result(appVersionService.selectAllPage(pageNo,pageSize));
    }
    @RequestMapping("getAppVersionAllById")
    public Result getAppVersionAllById(Integer id){
        return new Result(appVersionService.selectByPrimaryKey(id));
    }
    @RequestMapping(value = "updateAppVersionById",method = RequestMethod.POST)
    public Result updateAppVersionAllById(@RequestBody AppVersion appVersion){
       return new Result(appVersionService.updateByPrimaryKeySelective(appVersion));
    }

    @RequestMapping(value = "deletePersonById",method = RequestMethod.POST)
    public Result deletePersonById(@RequestBody Integer id) {
        int i = appVersionService.deleteByPrimaryKey(id);
        return new Result(i);
    }

    @RequestMapping(value = "insertPerson",method = RequestMethod.POST)
    public Result insertPerson(@RequestBody AppVersion appVersion) {
        appVersion.setCreateDate(new Date());
        appVersion.setUpdateDate(new Date());
        appVersion.setDelFlag("0");
        return new Result(appVersionService.insertSelective(appVersion));
    }

}
