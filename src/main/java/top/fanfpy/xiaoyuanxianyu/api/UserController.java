package top.fanfpy.xiaoyuanxianyu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.domain.UserRepository;
import top.fanfpy.xiaoyuanxianyu.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * @author fanfp
 * @date 2018/04/18
 * */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 获取全部的user信息
     * */
    @GetMapping(value = "/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }



    /**
     * 添加一个新用户
     * */
    @PostMapping(value = "/")
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

    /**
     * 通过id获取用户信息
     * */
    @GetMapping(value = "/{id}")
    public Optional<User> getOneUser(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    /**
     *通过id更新用户
     * */
    @PutMapping(value = "/{id}")
    public User upateUser(@PathVariable("id") Integer id,@RequestParam("phone") String phone ,
                          @RequestParam("username") String username, @RequestParam("password") String password,
                          @RequestParam("qq") String qq, @RequestParam("createAt") String createAt,
                          @RequestParam("goodNum") Integer goodNum, @RequestParam("power") Byte power,
                          @RequestParam("lastLogin") String lastLogin, @RequestParam("status") Byte status){
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setQq(qq);
        user.setCreateAt(createAt);
        user.setGoodsNum(goodNum);
        user.setPower(power);
        user.setLastLogin(lastLogin);
        user.setStatus(status);
        return userRepository.save(user);
    }


    /**
     * 通过id删除用户
     * */
    @DeleteMapping(value = "/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }


    /**
     *  通过name获取用户信息
    * */
    @GetMapping(value = "/name/{name}")
    public List<User> getUserName(@PathVariable("name") String name){
        return userRepository.findByUsername(name);
    }







}
