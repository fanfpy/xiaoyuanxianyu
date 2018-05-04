package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassificationServiceImplTest {

    @Autowired
    ClassificationServiceImpl classificationService;

    @Test
    public void save() {
        Classification  classification = new Classification();
        classification.setName("书籍");
        classification.setNumber(0);
        classification.setStatus((byte) 0);
        Classification res = classificationService.save(classification);
        Assert.assertNotNull(res);
    }
}