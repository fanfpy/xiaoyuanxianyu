package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
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

    /**
     * @param username 用户名
     * @param password 密码
     * @return 返回用户 否则为空
     * */
    User findByUsernameAndPassword(String username , String password);


    /**
     * @param openid
     * @return 返回user
     * */
    List<User> findByOpenid(String openid);


}
