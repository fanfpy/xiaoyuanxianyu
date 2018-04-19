package top.fanfpy.xiaoyuanxianyu.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * @author fanfp
 * */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过name查询
     * @param username 用户名
     * */
    public List<User> findByUsername(String username);
}
