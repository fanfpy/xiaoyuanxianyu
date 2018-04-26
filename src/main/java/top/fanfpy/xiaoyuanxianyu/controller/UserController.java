package top.fanfpy.xiaoyuanxianyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login.to")
    public String toLogin(){
        return "user/toLogin";
    }

    @PostMapping("/login")
    public String login(String username , String password , HttpServletRequest request , ModelMap modelMap){
        User user =userService.login(username,password);
        if(user != null){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else{
            modelMap.addAttribute("erro","用户名或密码错误");
            return "user/toLogin";
        }
    }

    @GetMapping("/")
    public String userIndex(HttpServletRequest request){
        //验证是否登陆
        if (request.getSession().getAttribute("user")==null){
            return "redirect:/";
        }
        return "user/index";
    }
}
