package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.entity.Result;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.utils.ResultUtils;

import javax.validation.Valid;
import java.util.List;

/**
 * @author fanfp
 * @date 2018/04/18
 * */
@RequestMapping(value = "/api/user")
@RestController
public class UserApiController {
    private final UserRepository userRepository;
    @Autowired
    public UserApiController(UserRepository userRepository) {
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
    public Result addUser(@Valid User user , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtils.erro(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(userRepository.save(user));
    }
    /**
     * 通过id获取用户信息
     * */
    @GetMapping(value = "/{id}")
    public Result getOneUser(@PathVariable("id") Integer id){
        return ResultUtils.success(userRepository.findById(id));
    }
    /**
     *通过id更新用户
     *
     * 打印错误
     * */
    @PutMapping(value = "/{id}")
    public Result upateUser(@PathVariable("id")  User user ){
        return ResultUtils.success(userRepository.save(user));
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
    public User getUserName(@PathVariable("name") String name){
        return userRepository.findByUsername(name);
    }
}
