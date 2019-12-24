package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsImgRepository;
import top.fanfpy.xiaoyuanxianyu.service.GoodsImgService;

import java.util.List;
/**
 * @author fanfp
 * */
@Service
public class GoodsImgServiceImpl implements GoodsImgService {

    @Autowired
    GoodsImgRepository goodsImgRepository;

    @Override
    public List<GoodsImg> finaByGoodsId(Integer goodsId) {
        return goodsImgRepository.findByGoodsId(goodsId,null);
    }

    @Override
    public GoodsImg save(GoodsImg goodsImg) {
        return goodsImgRepository.save(goodsImg);
    }
}
