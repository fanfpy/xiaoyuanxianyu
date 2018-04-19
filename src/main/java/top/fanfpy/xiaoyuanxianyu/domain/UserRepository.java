package top.fanfpy.xiaoyuanxianyu.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

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
