package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.fanfpy.xiaoyuanxianyu.entity.User;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("烦fpy");
        user.setPassword("123456");
        user.setEmail("fanfpy@qq.com");
        user.setGoodsNum(0);
        user.setPhone("17602917228");
        user.setPower((byte) 0);
        user.setQq("2324802641");
        user.setUserImg("http:xxx.xxx.jpg");
        user.setStatus((byte) 0);
        Assert.assertNotNull(userService.save(user));
    }
}