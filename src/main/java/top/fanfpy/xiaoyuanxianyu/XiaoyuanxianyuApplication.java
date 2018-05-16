package top.fanfpy.xiaoyuanxianyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

@SpringBootApplication
public class XiaoyuanxianyuApplication {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(XiaoyuanxianyuApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(XiaoyuanxianyuApplication.class, args);
    }
}
