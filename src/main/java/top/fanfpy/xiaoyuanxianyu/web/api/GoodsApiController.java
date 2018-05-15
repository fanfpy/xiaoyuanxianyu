package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanfpy.xiaoyuanxianyu.VO.GoodsInfoVO;
import top.fanfpy.xiaoyuanxianyu.VO.GoodsVO;
import top.fanfpy.xiaoyuanxianyu.VO.ClassVO;
import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.service.ClassificationService;
import top.fanfpy.xiaoyuanxianyu.service.GoodsImgService;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;
import top.fanfpy.xiaoyuanxianyu.service.UserService;
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
    @Autowired
    UserService userService;
    @Autowired
    GoodsImgService goodsImgService;

    @GetMapping("/hot/list")
    public ResultVO<Object> getHotGoodsList(){

        List<GoodsInfoVO> goodsInfoVOList = new ArrayList<>();

        List<Goods> goodsList = goodsSrevice.findByPageView().getContent();
        for (Goods goods:goodsList) {
            GoodsInfoVO goodsInfoVO = new GoodsInfoVO();

            List<String> stringList = new ArrayList<>();
            User user = userService.finaUserId(goods.getUserId()).get();
            for (GoodsImg goodsImg:goodsImgService.finaByGoodsId(goods.getId())) {
                stringList.add(goodsImg.getImgUrl());
            }

            goodsInfoVO.setGoodsId(goods.getId());
            goodsInfoVO.setUserId(goods.getUserId());
            goodsInfoVO.setUserName(user.getUsername());
            goodsInfoVO.setUserImg(user.getUserImg());
            goodsInfoVO.setGoodsTitlie(goods.getName());
            goodsInfoVO.setPrice(goods.getPrice());
            goodsInfoVO.setPageView(goods.getPageView());
            goodsInfoVO.setStatus(goods.getStatus());
            goodsInfoVO.setDescrible(goods.getDescrible());
            goodsInfoVO.setUpdateTime(goods.getUpdateTime());
            goodsInfoVO.setGoodsImgList(stringList);

            goodsInfoVOList.add(goodsInfoVO);

        }

        return ResultUtils.success(goodsInfoVOList);
    }

    @GetMapping(value = "/{id}")
    public ResultVO<Object> getGoodsId(@PathVariable("id") Integer id){
        GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
        Goods goods= goodsSrevice.findById(id).get();
        List<String> stringList = new ArrayList<>();
        User user = userService.finaUserId(goods.getUserId()).get();
        for (GoodsImg goodsImg:goodsImgService.finaByGoodsId(id)) {
            stringList.add(goodsImg.getImgUrl());
        }

        goodsInfoVO.setGoodsId(id);
        goodsInfoVO.setUserId(goods.getUserId());
        goodsInfoVO.setUserName(user.getUsername());
        goodsInfoVO.setUserImg(user.getUserImg());
        goodsInfoVO.setGoodsTitlie(goods.getName());
        goodsInfoVO.setPrice(goods.getPrice());
        goodsInfoVO.setPageView(goods.getPageView());
        goodsInfoVO.setStatus(goods.getStatus());
        goodsInfoVO.setDescrible(goods.getDescrible());
        goodsInfoVO.setUpdateTime(goods.getUpdateTime());
        goodsInfoVO.setGoodsImgList(stringList);

        return ResultUtils.success(goodsInfoVO);
    }

}
