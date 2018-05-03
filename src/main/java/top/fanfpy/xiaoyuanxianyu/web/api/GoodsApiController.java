package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;

@RestController
@RequestMapping(value = "/api/goods")
public class GoodsApiController {

    @Autowired
    GoodsSrevice goodsSrevice;

    @GetMapping(value = "/list")
    public void goodList(){

    }


}
