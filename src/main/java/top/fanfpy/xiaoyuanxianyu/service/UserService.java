package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public User addUser(User user);

    public void delUser(Integer id);

    public User updateUser(User user);

    public List<User> listUser();

    public Optional<User> getUserOne(Integer id);
}
