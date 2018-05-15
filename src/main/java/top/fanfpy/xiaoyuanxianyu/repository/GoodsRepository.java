package top.fanfpy.xiaoyuanxianyu.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;

import java.util.List;


public interface GoodsRepository extends JpaRepository<Goods ,Integer> {

    /**
     * 通过分类id查询
     * */
    List<Goods> findByClassificationId(Integer classifiactionId);

    /**
     * 分页查询
     * */
    Page<Goods> findAll(Pageable pageable);

//    Pageable findAll(Pageable pageable);
}
