package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GoodsSrevice {


    /**
     * 查询所有商品
     * @return 返回集合
     * */
    List<Goods> listGoods();

    /**
     * @param goods
     *增加商品 且增加所在分类下的数字 用户对应的上架数量
     * */
    Goods addGood(Goods goods);

    /**
     * @param goods 商品对象
     * */
    Goods upGoods(Goods goods);
    /**
     * 删除商品
     * @param id 商品id
     * */
    void delGoods(Integer id);

    /**
     * 分页查询所有商品
     * @param pageable
     * @return 返回页
     * */
    Page<Goods> findAll(Pageable pageable);

    List<Goods> findallGood();

    /**
     * 通过id查商品
     * */
    Optional<Goods> findById(Integer id);

    List<Goods> findByClassifiaction(Integer classifiactionId);
}
