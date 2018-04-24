package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GoodsSrevice {
    /**
     * 增加商品
     * @param goods 商品
     * @return 返回增加的商品
     * */
    Goods addGoods(Goods goods);

    /**
     * 删除商品
     * @param id 商品id
     * */
    void delGoods(Integer id);

    /**
     * 修改商品
     * @param goods 商品
     * @return 返回修改的商品
     * */
    Goods updateGoods(Goods goods);

    /**
     * 分页查询所有商品
     * @param pageable
     * @return 返回页
     * */
    Page<Goods> findAll(Pageable pageable);

    /**
     * 通过分类 分页查询
     * @param id 分类id
     * @param pageable 分页参数 */
     Optional<Goods> findByClassificationId(Integer id , Pageable pageable);
}
