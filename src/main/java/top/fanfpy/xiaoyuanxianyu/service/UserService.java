package top.fanfpy.xiaoyuanxianyu.service;


import top.fanfpy.xiaoyuanxianyu.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author fanfp
 * @date 2018/4/23
 * */
public interface UserService {
    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return user
     * */
    User login(String username, String password);

    /**
     * @param user 用户
     * @return 返回user
     * 保存修改用户
     * */
    User save(User user);

    /**
     * 通过id删除用户
     * @param id 用户id
     * */
    void delUser(Integer id);

    /**
     * @param id 用户ID
     * 通过id查询用户
     * */
    Optional<User> finaUserId(Integer id);

    /**
     * @param openid 微信openid
     *通过openid查询用户
     * */
    User findByOpenid(String openid);

}
