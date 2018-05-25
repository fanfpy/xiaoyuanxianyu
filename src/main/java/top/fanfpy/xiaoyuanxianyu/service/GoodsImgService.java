package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;

import java.util.List;
/**
 * @author fanfp
 * */
public interface GoodsImgService {
    /**
     * @param goodsId 商品id
     * @return 返回商品图片列表
     *通过商品id查询
     * */
    List<GoodsImg> finaByGoodsId(Integer goodsId);

    /**
     * @param goodsImg 图片对象
     * */
    void save(GoodsImg goodsImg);
}
