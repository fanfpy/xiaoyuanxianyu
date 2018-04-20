package top.fanfpy.xiaoyuanxianyu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fanfpy.xiaoyuanxianyu.domain.User;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @PostMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Integer id) {
        Optional<User> user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }
}
