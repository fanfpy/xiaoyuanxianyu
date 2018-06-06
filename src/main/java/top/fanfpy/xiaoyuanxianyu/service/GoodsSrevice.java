package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.VO.GoodsInfoVO;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
/**
 * @author fanfp
 * */
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
    Goods saveGood(Goods goods);

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

    /**通过分类 返回商品数组
     * @return 商品数组
     * */
    List<Goods> findByClassifiaction(Integer classifiactionId);

    /**
     * 分页查询热门商品
     * @return 商品页
     * @param size 每页显示的内容
     * @param start 开始页
     * */
    Page<Goods> findByHotGoods(Integer start,Integer size);

    /**
     * 分页查询id倒序
     * @return 商品页
     * @param size 每页显示的内容
     * @param start 开始页
     * */
    Page<Goods> findByNewGoods(Integer start,Integer size);

    /**
     * @date 2018/6/6
     *直接返回页面所需要的商品信息 包括用户头像 商品图片 减少Controller的复杂程度
     * 因预览页和详情页（预览页最多三张图片） 显示图片的数量不同 所以增加了imgMun
     * @param goodsId 商品id
     * @param imgNum 图片数量
     * */
    GoodsInfoVO GoodsInfo(Integer goodsId,Integer imgNum);
}
