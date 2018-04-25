package top.fanfpy.xiaoyuanxianyu.service;


import org.springframework.ui.ModelMap;
import top.fanfpy.xiaoyuanxianyu.entity.User;

import javax.servlet.http.HttpServletRequest;

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
     * 注册
     * @param user 用户对象
     * @return user
     * */
    User addUser(User user);

    /**
     * 修改用户
     * @param user yonghu
     * @return 返回修改后的值
     * */
    User upDate(User user);

    /**
     * 通过id删除用户
     * @param id 用户id
     * */
    void delUser(Integer id);
}
