package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.fanfpy.xiaoyuanxianyu.domain.User;
import top.fanfpy.xiaoyuanxianyu.domain.UserRepository;
import top.fanfpy.xiaoyuanxianyu.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository ;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
