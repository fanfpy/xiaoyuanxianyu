package top.fanfpy.xiaoyuanxianyu.domain;

import javax.persistence.*;

/**
 * @author fanfp
 * @date 2018/04/19
 * User实体类
 * */
@Entity
@Table(name = "user")
public class User {

    /**
     * GeneratedValue(strategy = GenerationType.IDENTITY) 表示自增长方式使用mysql自带的
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phone;

    private String username;

    private String password;

    private String qq;

    private String createAt;

    private Integer goodsNum;

    private Byte power;

    private String lastLogin;

    private Byte status;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt == null ? null : createAt.trim();
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

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin == null ? null : lastLogin.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", qq='" + qq + '\'' +
                ", createAt='" + createAt + '\'' +
                ", goodsNum=" + goodsNum +
                ", power=" + power +
                ", lastLogin='" + lastLogin + '\'' +
                ", status=" + status +
                '}';
    }
}