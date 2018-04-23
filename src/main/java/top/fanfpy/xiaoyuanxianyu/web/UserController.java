package top.fanfpy.xiaoyuanxianyu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author fanfp
 * */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUser(ModelMap map){
        map.addAttribute("users",userService.listUser());
        return "list";
    }

    @GetMapping("/update/{id}")
    public String updateUser(ModelMap map,@PathVariable("id") Integer id){
        map.addAttribute("user",userService.getUserOne(id));
        return "toUpdateUser";
    }

    @RequestMapping("/delUser/{id}")
    public String delUpdate(@PathVariable Integer id){
        userService.delUser(id);
        return "redirect:/list";
    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "/adduser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user , ModelMap modelMap){
        User u =userService.getUsername(user.getUsername());
        if (u != null){
            modelMap.addAttribute("error","用户已存在");
            return "/addUser";
        }
        userService.addUser(user);
        return "redirect:/list";
    }
}
