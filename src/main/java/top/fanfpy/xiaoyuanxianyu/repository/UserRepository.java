package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.domain.User;

/**
 * @author fanfp
 * */
public interface UserRepository extends JpaRepository<User, Integer> {

}
