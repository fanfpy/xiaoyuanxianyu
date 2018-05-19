package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.VO.GoodsInfoVO;
import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;
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

/**
 * @author fanfp
 *
 * */
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

        List<Goods> goodsList = goodsSrevice.findByHotGoods(0,5).getContent();
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
            goodsInfoVO.setGoodsTitle(goods.getName());
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
        goodsInfoVO.setGoodsTitle(goods.getName());
        goodsInfoVO.setPrice(goods.getPrice());
        goodsInfoVO.setPageView(goods.getPageView());
        goodsInfoVO.setStatus(goods.getStatus());
        goodsInfoVO.setDescrible(goods.getDescrible());
        goodsInfoVO.setUpdateTime(goods.getUpdateTime());
        goodsInfoVO.setGoodsImgList(stringList);

        return ResultUtils.success(goodsInfoVO);
    }

    @PostMapping("/")
    public void saveGoods(Goods goods){
        goodsSrevice.saveGood(goods);
    }

    @PutMapping("/{id}")
    public void updateGoods(Goods goods){
        goodsSrevice.saveGood(goods);
    }

    @DeleteMapping("/{id}")
    public void delGoods(@PathVariable("id") Integer id){
        goodsSrevice.delGoods(id);
    }
}
