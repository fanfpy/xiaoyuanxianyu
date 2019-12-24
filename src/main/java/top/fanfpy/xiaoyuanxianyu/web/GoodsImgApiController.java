package top.fanfpy.xiaoyuanxianyu.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.fanfpy.xiaoyuanxianyu.config.AliOss;
import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;
import top.fanfpy.xiaoyuanxianyu.service.GoodsImgService;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/img")
public class GoodsImgApiController {

    @Autowired
    GoodsImgService goodsImgService;


    @Autowired
    AliOss aliOss;


    @PostMapping("/add")
    public GoodsImg addImg(@RequestParam("file") MultipartFile file, @RequestParam(value = "goodsId") Integer goodsId) throws IOException {
        return goodsImgService.save(new GoodsImg(goodsId, aliOss.updateImg(file.getInputStream(),file.getOriginalFilename())));
    }

    @PostMapping(value = "test/update")
    public String testUpdate(@RequestParam("file") MultipartFile file) throws IOException {
        return aliOss.updateImg(file.getInputStream(),file.getOriginalFilename());
    }
}
