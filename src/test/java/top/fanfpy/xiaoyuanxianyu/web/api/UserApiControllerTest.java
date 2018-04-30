package top.fanfpy.xiaoyuanxianyu.web.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUserName() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/api/user/name/fanfpy"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}