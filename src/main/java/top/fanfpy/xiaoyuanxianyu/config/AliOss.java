package top.fanfpy.xiaoyuanxianyu.config;

import cn.hutool.core.date.DateUtil;
import org.springframework.context.annotation.Configuration;
import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.InputStream;

@Component
@Configuration
public class AliOss {

  @Value("${endpoint}")
  private String endpoint;

  @Value("${accessKeyId}")
  private String accessKeyId;

  @Value("${accessKeySecret}")
  private String accessKeySecret;

  @Value("${bucketName}")
  private String bucketName;

  public OSSClient ossClient(){
    return new OSSClient(this.endpoint,this.accessKeyId,this.accessKeySecret);
  }

  /**
   * 文件流和文件名
   * return 文件路径
   * */
  public String updateImg(InputStream inputStream, String fileName){
    long time  = System.currentTimeMillis();
    ossClient().putObject(this.bucketName, DateUtil.today() +"/"+time+fileName,inputStream);
    return "https://" +this.bucketName+"." +this.endpoint + "/" + DateUtil.today() +"/"+time+fileName;
  }
}
