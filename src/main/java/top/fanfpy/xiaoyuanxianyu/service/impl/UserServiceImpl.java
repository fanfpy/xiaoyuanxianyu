package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * @author fanfp
 * @date 2018/4/23
 * */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> finaUserId(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByOpenid(String openid) {
        return userRepository.findByOpenid(openid);
    }
}
