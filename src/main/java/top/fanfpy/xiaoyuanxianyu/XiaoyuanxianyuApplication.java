package top.fanfpy.xiaoyuanxianyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class XiaoyuanxianyuApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XiaoyuanxianyuApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(XiaoyuanxianyuApplication.class, args);
    }

}
