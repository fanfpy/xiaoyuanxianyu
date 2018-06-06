package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.service.UserService;
import top.fanfpy.xiaoyuanxianyu.utils.ResultUtils;

import javax.validation.Valid;

/**
 * @author fanfp
 * @date 2018/04/18
 * */
@RequestMapping(value = "/api/user")
@RestController
public class UserApiController {

    @Autowired
    UserService userService;
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
        return ResultUtils.success(userService.save(user));
    }

    /**
     *通过id更新用户
     * 打印错误
     * */
    @PutMapping(value = "/{id}")
    public ResultVO upateUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") Integer id){
        if (bindingResult.hasErrors()){
            return ResultUtils.erro(bindingResult.getFieldError().getDefaultMessage());
        }
        user.setId(id);
        return ResultUtils.success(userService.save(user));
    }
    @GetMapping("/list")
    public ResultVO list(){
        return ResultUtils.success(userService.finaUserId(2));
    }

    /**
     * 通过openid获取用户信息
     *
     * 假如存在相同openid的用户 这里会报错 所以 改改改
     * @date 2018/6/6
     * */
    @GetMapping(value = "openid/{openid}")
    public ResultVO findByOpenid(@PathVariable("openid") String openid){
        return ResultUtils.success(userService.findByOpenid(openid));
    }
}
