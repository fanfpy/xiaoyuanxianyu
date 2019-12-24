package top.fanfpy.xiaoyuanxianyu.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class GoodsImgRepositoryTest {

    @Autowired
    private GoodsImgRepository goodsImgRepository;

    @Test
    void findByGoodsIdLimit() {

    }

    @Test
    void findByGoodsId() {
        goodsImgRepository.findByGoodsId(1, PageRequest.of(0,3)).forEach(System.out::println);
    }
}
