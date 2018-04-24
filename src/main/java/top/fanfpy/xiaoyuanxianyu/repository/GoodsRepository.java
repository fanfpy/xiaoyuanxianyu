package top.fanfpy.xiaoyuanxianyu.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;

import java.util.Optional;


public interface GoodsRepository extends JpaRepository<Goods , Integer> {

    Optional<Goods> findById(Integer id, Pageable pageable);
}
