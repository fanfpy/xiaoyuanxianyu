package top.fanfpy.xiaoyuanxianyu.config;

import org.springframework.context.annotation.Configuration;

import com.aliyun.oss.OSSClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configuration
public class AliOssConfig{

  @Value("${endpoint}")
  private String endpoint;

  @Value("${accessKeyId}")
  private String accessKeyId;

  @Value("${accessKeySecret}")
  private String accessKeySecret;

  @Bean
  public OSSClient ossClient(){
    return new OSSClient(this.endpoint,this.accessKeyId,this.accessKeySecret);
  }
}