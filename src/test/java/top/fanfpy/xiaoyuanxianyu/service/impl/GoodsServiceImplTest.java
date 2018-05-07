package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceImplTest {

    @Autowired
    GoodsServiceImpl goodsService;

    @Test
    public void addGood() {
        Goods goods = new Goods();
        goods.setName("Mysql从入门到跑路");
        goods.setClassificationId(3);
        goods.setUserId(2);
        goods.setDescrible("描述：Mysql从入门到跑路");
        goods.setPrice(new BigDecimal(2999.9));
        goods.setCommetNum(0);
        goods.setImg("http://xxx.com/xxx.jpg");
        goods.setStatus((byte) 0);

        Assert.assertNotNull(goodsService.addGood(goods));
    }
}