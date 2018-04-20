package top.fanfpy.xiaoyuanxianyu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUser(Model model){
        model.addAttribute("users",userService.listUser());
        return "list";
    }
}
