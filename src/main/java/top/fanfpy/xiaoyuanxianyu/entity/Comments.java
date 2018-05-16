package top.fanfpy.xiaoyuanxianyu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author fanfpy
 * @date 2018/4/23
 * */
@Entity(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer goodsId;


    private String content;

    @Column(name = "create_at")
    private String date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}