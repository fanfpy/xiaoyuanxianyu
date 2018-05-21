package top.fanfpy.xiaoyuanxianyu.entity;

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
@Entity(name = "user")
public class User {

    /**
     * GeneratedValue(strategy = GenerationType.IDENTITY) 表示自增长方式使用mysql自带的
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "手机号不能为空")
//    @Length(min = 11 , message = "手机号")
    private String phone;

    @NotNull(message = "用户名不能为空")
    private String username;

    @Column(nullable = false)
    private String password;

    @NotNull(message = "qq不能为空")
    private String qq;

    @NotNull(message = "邮箱不能为空")
//    @Email
    private String email;

    private String openid;

    @NotNull(message = "发布数不能为空")
    private Integer goodsNum;


    @NotNull(message = "权限值默认为10")
    private Byte power;


    @NotNull(message = "是否冻结默认为0，1为未激活，2为封禁")
    private Byte status ;

    @Column(name = "user_img")
    @NotNull(message = "用户头像")
    private String userImg;


    public Integer getId() {
        new Random().nextInt();
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }


    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Byte getPower() {
        return power;
    }

    public void setPower(Byte power) {
        this.power = power;
    }


    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", openid='" + openid + '\'' +
                ", goodsNum=" + goodsNum +
                ", power=" + power +
                ", status=" + status +
                ", userImg='" + userImg + '\'' +
                '}';
    }
}