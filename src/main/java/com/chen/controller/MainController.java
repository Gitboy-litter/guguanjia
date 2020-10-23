package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.controller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/23 16:22
 * @Version: 1.0
 */
@Controller
@RequestMapping("main/")
public class MainController {
    @RequestMapping("sidebar")
    public ModelAndView sidebar(){
        return new ModelAndView("/command/sidebar.html");
    }
    @RequestMapping("navbar")
    public ModelAndView navbar(){
        return new ModelAndView("/command/navbar.html");
    }
}
