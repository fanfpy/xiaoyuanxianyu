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

    /**
     * 分页查询
     * @param pageable 也的参数
     * @return 返回商品页
     * */
//    Page<Goods> findByPageView(Pageable pageable);
}
