package top.fanfpy.xiaoyuanxianyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexConntroller {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
