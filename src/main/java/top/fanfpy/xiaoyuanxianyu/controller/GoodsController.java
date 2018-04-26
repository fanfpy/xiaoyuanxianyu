package top.fanfpy.xiaoyuanxianyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;


@Controller
@RequestMapping("/product")
public class GoodsController {

    @Autowired
    GoodsSrevice goodsSrevice;
    @GetMapping("/{id}")
    public String good(@PathVariable Integer id , ModelMap modelMap){
        modelMap.addAttribute("good",goodsSrevice.findById(id));
        System.out.println(goodsSrevice.findById(id));
        return "product";
    }
}
