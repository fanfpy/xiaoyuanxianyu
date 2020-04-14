package top.fanfpy.xiaoyuanxianyu.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class GoodsRepositoryTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    void findByUserId() {
        goodsRepository.findByUserId(1).forEach(System.out::println);
    }
}
