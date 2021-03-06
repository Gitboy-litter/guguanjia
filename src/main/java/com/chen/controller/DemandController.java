package com.chen.controller;

import com.chen.entity.AppVersion;
import com.chen.entity.Demand;
import com.chen.entity.Result;
import com.chen.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.controller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/23 17:33
 * @Version: 1.0
 */
@RestController
@RequestMapping("manager/demand")
public class DemandController {

    @Autowired
    private DemandService demandService;

    @RequestMapping("index.html")
    public ModelAndView toDemand() {
        return new ModelAndView("/demand/index.html");
    }
    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(){
        return new ModelAndView("/demand/update.html");
    }
    @RequestMapping("toDetail")
    public ModelAndView toDetail() {
        return new ModelAndView("/demand/detail.html");
    }
    @RequestMapping(value = "updateAppVersionById",method = RequestMethod.POST)
    public Result updateAppVersionAllById(@RequestBody Demand demand){
        return new Result(demandService.updateByPrimaryKeySelective(demand));
    }

    @RequestMapping("getDemandAll")
    public Result getDemandAll(Integer pageNo, Integer pageSize){
        return new Result(demandService.selectAllPage(pageNo,pageSize));
    }
}
