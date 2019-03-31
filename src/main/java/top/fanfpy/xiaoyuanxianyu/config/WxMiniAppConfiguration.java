package top.fanfpy.xiaoyuanxianyu.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WxMiniAppConfiguration {

    private Logger log = LoggerFactory.getLogger(WxMiniAppConfiguration.class);
    /**
     * 设置微信小程序的appid
     */
    @Value("${wx.miniapp.appid}")
    private String appid;

    /**
     * 设置微信小程序的Secret
     */
    @Value("${wx.miniapp.secret}")
    private String secret;

    /**
     * 设置微信小程序消息服务器配置的token
     */
    @Value("${wx.miniapp.token}")
    private String token;

    /**
     * 设置微信小程序消息服务器配置的EncodingAESKey
     */
    @Value("${wx.miniapp.aesKey}")
    private String aesKey;

    /**
     * 消息格式，XML或者JSON
     */
    @Value("${wx.miniapp.msgDataFormat}")
    private String msgDataFormat;

    @Bean
    public WxMaInMemoryConfig WxConfig() {
        WxMaInMemoryConfig config = new WxMaInMemoryConfig();
        config.setAppid(this.appid);
        config.setSecret(this.secret);
        config.setToken(this.token);
        config.setAesKey(this.aesKey);
        config.setMsgDataFormat(this.msgDataFormat);
        return config;
    }

    @Bean
    public WxMaService Service() {
        WxMaService service  = new WxMaServiceImpl();
        service.setWxMaConfig(WxConfig());
        return service;
    }
}
