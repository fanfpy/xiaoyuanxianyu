package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;

import java.util.Optional;

public interface ClassificationRepository extends JpaRepository<Classification , Integer> {


}
