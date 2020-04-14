package top.fanfpy.xiaoyuanxianyu.repository;


import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;

import java.util.List;

/**
 * @author fanfp
 * */
public interface GoodsRepository extends JpaRepository<Goods ,Integer> {

    /**
     * 通过分类id查询
     * @param classifiactionId 商品分类id
     * @return 返回商品列表
     * */
    List<Goods> findByClassificationId(Integer classifiactionId);


    List<Goods> findByUserId(Integer userId);
}
