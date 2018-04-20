package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getUserList();

    public Optional<User> findUserById(Integer id);

    public void save(User user);

    public void edit(User user);

    public void delete(Integer id);
}
