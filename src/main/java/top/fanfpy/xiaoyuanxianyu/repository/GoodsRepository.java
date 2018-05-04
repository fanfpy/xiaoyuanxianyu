package top.fanfpy.xiaoyuanxianyu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;

import java.util.List;


public interface GoodsRepository extends JpaRepository<Goods , Integer> {

    /**
     * 通过分类id查询
     * */
    List<Goods> findByClassificationId(Integer classifiactionId);
}
