package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.VO.GoodsInfoVO;
import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
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

    @GetMapping(value = "/hot/{num}")
    public ResultVO<Object> getHotGoodsList(@PathVariable("num") Integer num){
        List<GoodsInfoVO> goodsInfoVOList = new ArrayList<>();
        //分页
        List<Goods> goodsList = goodsSrevice.findByHotGoods(0,num).getContent();
        for (Goods goods:goodsList) {
            goodsInfoVOList.add(goodsSrevice.GoodsInfo(goods.getId(),3));

        }

        return ResultUtils.success(goodsInfoVOList);
    }


    @GetMapping("/new/{num}")
    public ResultVO<Object> getNewGoodsList(@PathVariable("num") Integer num){
        List<GoodsInfoVO> goodsInfoVOList = new ArrayList<>();
        //分页
        List<Goods> goodsList = goodsSrevice.findByNewGoods(0,num).getContent();
        for (Goods goods:goodsList) {
            goodsInfoVOList.add(goodsSrevice.GoodsInfo(goods.getId(),3));
        }

        return ResultUtils.success(goodsInfoVOList);
    }


    @GetMapping(value = "id/{id}")
    public ResultVO<Object> getGoodsId(@PathVariable("id") Integer id){
        //商品详细页
        return ResultUtils.success(goodsSrevice.GoodsInfo(id,9));
    }

    @PostMapping("/")
    public void saveGoods(Goods goods){
        goodsSrevice.saveGood(goods);
    }

    @PutMapping("/{id}")
    public void updateGoods(Goods goods){
        goodsSrevice.saveGood(goods);
    }

    //传入goods
    @PostMapping("/add")
    public ResultVO addGoods( Goods goods){
     return ResultUtils.success(goodsSrevice.saveGood(goods));
    }

    //返回分类表
    @GetMapping("/class")
    public ResultVO listClassifiction(){
        return ResultUtils.success(classificationService.listClassification());
    }

    @GetMapping(value = "classId/{classId}")
    public ResultVO listGoodsForClass(@PathVariable("classId") Integer classId){
        List<GoodsInfoVO> goodsInfoVOList = new ArrayList<>();
        List<Goods> goodsList = goodsSrevice.findByClassifiaction(classId);
        for (Goods goods:
             goodsList) {
            goodsInfoVOList.add(goodsSrevice.GoodsInfo(goods.getId(),3));
        }
        return ResultUtils.success(goodsInfoVOList);
    }
}
