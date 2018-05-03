package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;

import java.util.Optional;

public interface ClassificationRepository extends JpaRepository<Classification , Integer> {
    /**
     *
     * */
    @Query(value = "update classification set number = number+1 where id = :id",nativeQuery = true)
    void addNumber(@Param("id") Integer id);
}
