package top.fanfpy.xiaoyuanxianyu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

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

    @RequestMapping(value = "/delUser/{id}")
    public String delUpdate(@PathVariable Integer id){
        userService.delUser(id);
        return "redirect:/list";
    }
}
