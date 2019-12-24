package top.fanfpy.xiaoyuanxianyu.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Random;

/**
 * @author fanfp
 * @date 2018/04/19
 * User实体类
 * */
@Data
@Entity(name = "user")
public class User {

    /**
     * GeneratedValue(strategy = GenerationType.IDENTITY) 表示自增长方式使用mysql自带的
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;

    @NotNull(message = "用户名不能为空")
    private String username;

    private String password;

    private String qq;

    private String email;

    private String openid;

    private Integer goodsNum = 0;


    @NotNull(message = "权限值默认为10")
    private Byte power = 0;


    @NotNull(message = "是否冻结默认为0，1为未激活，2为封禁")
    private Byte status = 0;

    @Column(name = "user_img")
    @NotNull(message = "用户头像")
    private String userImg;


    public Integer getId() {
        new Random().nextInt();
        return id;
    }
}
