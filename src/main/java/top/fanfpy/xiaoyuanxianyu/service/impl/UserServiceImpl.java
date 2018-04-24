package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fanfp
 * @date 2018/4/23
 * */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(HttpServletRequest request , String username, String password , ModelMap modelMap) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user!=null){
            request.getSession().setAttribute("login_user",user);
        }else{
            modelMap.addAttribute("erro","用户名或密码错误");
        }
        return user;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User upDate(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delUser(Integer id) {
        userRepository.deleteById(id);
    }
}
