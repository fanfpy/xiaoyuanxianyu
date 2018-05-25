package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        //分页
        List<Goods> goodsList = goodsSrevice.findByHotGoods(0,5).getContent();
        for (Goods goods:goodsList) {

            GoodsInfoVO goodsInfoVO = new GoodsInfoVO();

            List<String> stringList = new ArrayList<>();

            User user = userService.finaUserId(goods.getUserId()).get();


            for (GoodsImg goodsImg:goodsImgService.finaByGoodsId(goods.getId())) {
                stringList.add(goodsImg.getImgUrl());
                //首页最多传三张图片
                if (stringList.size()>=3){
                    break;
                }
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

    @GetMapping(value = "id/{id}")
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

    //传入goods 和图片文件文件
    @PostMapping("/add")
    public String addGoods(HttpServletRequest request, @RequestParam(value = "flie") MultipartFile file , Goods goods){
        //获取文件名
        String fileName =file.getOriginalFilename();
        //获取服务器当前路径路径
        String destFileName =request.getServletContext().getRealPath("/img/")+file.getOriginalFilename();
        //当前服务器url+图片相对路径
        String url="";
        try {
            //创建路径
            File destFile = new File(destFileName);
           // destFile.mkdirs();
            destFile.getParentFile().mkdirs();
            //把上传的文件复制到这个目录
            file.transferTo(destFile);
            //将图片添加到数据库
            url = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort()+"/img/"+file.getOriginalFilename();
            //将商品添加到数据库

            //写一个业务类来处理这些逻辑

            //没有goodsid 无法存入img 把数据注入后在调用不就好了
            goodsImgService.save(new GoodsImg(goodsSrevice.saveGood(goods).getId(),url));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return fileName+"<br>"+destFileName+"<br>"+url;
    }
}
