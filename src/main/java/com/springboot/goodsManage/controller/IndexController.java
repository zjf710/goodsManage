package com.springboot.goodsManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // 发布货源
    @RequestMapping(value = "/app")
    public String index() {
        return "/index";
    }
}

