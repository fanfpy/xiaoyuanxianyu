package top.fanfpy.xiaoyuanxianyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;
import top.fanfpy.xiaoyuanxianyu.service.UserService;


@Controller
public class IndexController {
    @Autowired
    GoodsSrevice goodsSrevice;

    @GetMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("goods",goodsSrevice.findallGood());
        return "index";
    }
}
