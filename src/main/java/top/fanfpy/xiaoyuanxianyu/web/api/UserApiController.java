package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author fanfp
 * @date 2018/04/18
 * */
@RestController
@RequestMapping(value = "/api")
public class UserApiController {
    private final UserRepository userRepository;
    @Autowired
    public UserApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * 获取全部的user信息
     * */
    @GetMapping(value = "/user")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    /**
     * 添加一个新用户
     * */
    @PostMapping(value = "/user")
    public User addUser(User user){
        return  userRepository.save(user);
    }
    /**
     * 通过id获取用户信息
     * */
    @GetMapping(value = "/user/{id}")
    public Optional<User> getOneUser(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }
    /**
     *通过id更新用户
     * */
    @PutMapping(value = "/user/{id}")
    public User upateUser(User user){
        return userRepository.save(user);
    }
    /**
     * 通过id删除用户
     * */
    @DeleteMapping(value = "/user/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
    /**
     *  通过name获取用户信息
    * */
    @GetMapping(value = "/user/name/{name}")
    public List<User> getUserName(@PathVariable("name") String name){
        return userRepository.findByUsername(name);
    }
}
