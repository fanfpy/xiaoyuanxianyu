package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.utils.ResultUtils;

import javax.validation.Valid;

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
    public ResultVO<Object> getUsers(){
        return ResultUtils.success(userRepository.findAll());
    }
    /**
     * 添加一个新用户
     * */
    @PostMapping(value = "/")
    public ResultVO addUser(@Valid User user , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String str = null;
            for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {
                str+=bindingResult.getAllErrors().get(i).getDefaultMessage()+";";
            }
            return ResultUtils.erro(str);
        }
        return ResultUtils.success(userRepository.save(user));
    }
    /**
     * 通过id获取用户信息
     * */
    @GetMapping(value = "/{id}")
    public ResultVO<Object> getOneUser(@PathVariable("id") Integer id){
        return ResultUtils.success(userRepository.findById(id));
    }
    /**
     *通过id更新用户
     *
     * 打印错误
     * */
    @PutMapping(value = "/{id}")
    public ResultVO upateUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") Integer id){
        if (bindingResult.hasErrors()){
            return ResultUtils.erro(bindingResult.getFieldError().getDefaultMessage());
        }
        user.setId(id);
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
    public ResultVO<Object> getUserName(@Valid @PathVariable("name") String name){
        return ResultUtils.success(userRepository.findByUsername(name));
    }
}
