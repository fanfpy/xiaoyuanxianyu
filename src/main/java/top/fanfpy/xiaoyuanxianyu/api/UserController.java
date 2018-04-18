package top.fanfpy.xiaoyuanxianyu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * @author fanfp
 * @date 2018/04/18
 * */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取全部的user信息
     * */
    @GetMapping(value = "/user")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    /**
     * 通过id获取用户信息
     * */
    @GetMapping(value = "user/{id}")
    public Optional<User> getOneUser(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

   /**
    * 通过id删除用户
    * */
    @DeleteMapping(value = "user/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    /**
     * 添加用户
     * */
    @PostMapping(value = "/user")
    public User addUser(@RequestParam("phone") String phone , @RequestParam("username") String username,
                        @RequestParam("password") String password,@RequestParam("qq") String qq,
                        @RequestParam("createAt") String createAt,@RequestParam("goodNum") Integer goodNum,
                        @RequestParam("power") Byte power,@RequestParam("lastLogin") String lastLogin,
                        @RequestParam("status") Byte status){
        User user = new User();
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setQq(qq);
        user.setCreateAt(createAt);
        user.setGoodsNum(goodNum);
        user.setPower(power);
        user.setLastLogin(lastLogin);
        user.setStatus(status);
        return  userRepository.save(user);
    }


}
