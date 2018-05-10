package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;

import java.util.List;

public interface GoodsImgService {
    /**
     * @author fanfp
     * @date 2018/5/10
     *通过商品id查询
     * */
    List<GoodsImg> finaByGoodsId(Integer goodsId);
}
