package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanfpy.xiaoyuanxianyu.VO.GoodsVO;
import top.fanfpy.xiaoyuanxianyu.VO.ClassVO;
import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.service.ClassificationService;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;
import top.fanfpy.xiaoyuanxianyu.utils.ResultUtils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/goods")
public class GoodsApiController {

    @Autowired
    GoodsSrevice goodsSrevice;
    @Autowired
    ClassificationService classificationService;

    @GetMapping(value = "/list")
    public ResultVO<Object> goodList(){

        //返回所有分类
        List<Classification> classificationList = classificationService.listClassification();

        List<ClassVO> classVOList = new ArrayList<>();

        for (Classification classification:classificationList) {
            List<Goods> goodsList = goodsSrevice.findByClassifiaction(classification.getId());
            List<GoodsVO> goodsVOList = new ArrayList<>();
            ClassVO classVO = new ClassVO();
            for (Goods goods:goodsList) {
                GoodsVO goodsVO = new GoodsVO();
                goodsVO.setUserId(goods.getUserId());
                goodsVO.setCommetNum(goods.getCommetNum());
                goodsVO.setDescrible(goods.getDescrible());
                goodsVO.setGoodsId(goods.getId());
                goodsVO.setStatus(goods.getStatus());
                goodsVO.setGoodsImg(goods.getImg());
                goodsVO.setGoodsName(goods.getName());
                goodsVO.setGoodsPrice(goods.getPrice());

                goodsVOList.add(goodsVO);
            }
            classVO.setClassificationId(classification.getId());
            classVO.setClassificationName(classification.getName());
            classVO.setClassificationStatus(classification.getStatus());
            classVO.setGoodsList(goodsVOList);
            classVOList.add(classVO);
        }


        return ResultUtils.success(classVOList);
    }
}
