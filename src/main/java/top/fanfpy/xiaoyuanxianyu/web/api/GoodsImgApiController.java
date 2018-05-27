package top.fanfpy.xiaoyuanxianyu.web.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;
import top.fanfpy.xiaoyuanxianyu.service.GoodsImgService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/img")
public class GoodsImgApiController {

    @Autowired
    GoodsImgService goodsImgService;

    @PostMapping("/add")
    public GoodsImg addImg(HttpServletRequest request , @RequestParam("file") MultipartFile file, @RequestParam(value = "goodsId") Integer goodsId) {
        //获取文件名
        String fileName =file.getOriginalFilename();
        //获取服务器当前路径路径
        String destFileName =request.getServletContext().getRealPath("/img/")+file.getOriginalFilename();
        //当前网络路径 https://localhost:8080/img/xxx.jpg
        String url="";
        try{
            //创建路径
            File destFile = new File(destFileName);
            // destFile.mkdirs();
            destFile.getParentFile().mkdirs();
            //把上传的文件复制到这个目录
            file.transferTo(destFile);
            //将图片添加到数据库
            url = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort()+"/img/"+file.getOriginalFilename();
            System.out.println(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        return goodsImgService.save(new GoodsImg(goodsId,url));
    }
}
