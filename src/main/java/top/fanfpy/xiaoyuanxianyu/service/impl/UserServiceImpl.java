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
 * @date 2018/4/20
 * */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserOne(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
