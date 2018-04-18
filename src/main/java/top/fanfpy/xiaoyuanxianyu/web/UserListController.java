package top.fanfpy.xiaoyuanxianyu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserListController {

    @RequestMapping("/")
    public String helloController(ModelMap map){
        map.addAttribute("host","https://fanfpy.top");
        return "index";
    }

}
