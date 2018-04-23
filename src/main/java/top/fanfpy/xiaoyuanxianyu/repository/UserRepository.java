package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.fanfpy.xiaoyuanxianyu.entity.User;

import java.util.List;

/**
 * @author fanfp
 * @date 2018/4/19
 * */
public interface UserRepository extends JpaRepository<User, Integer> {

//    List<User> findByUsername(String username);
    /**
     * 通过name查询
     * @param username 用户名
     * @return 用户列表
     * */
    User findByUsername(String username);

}
