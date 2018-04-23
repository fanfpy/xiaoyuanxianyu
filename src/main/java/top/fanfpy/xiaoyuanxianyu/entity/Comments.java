package top.fanfpy.xiaoyuanxianyu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @NotNull(message = "对应用户ID不能为空")
    private Integer userId;

    @NotNull(message = "对应商品id不能为空")
    private Integer goodsId;

    @NotNull(message = "评论时间不能为空")
    private String createAt;

    @NotNull(message = "评论内容不能为空")
    private String content;

    public Comments(){}

    public Comments(@NotNull(message = "对应用户ID不能为空") Integer userId, @NotNull(message = "对应商品id不能为空") Integer goodsId, @NotNull(message = "评论时间不能为空") String createAt, @NotNull(message = "评论内容不能为空") String content) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.createAt = createAt;
        this.content = content;
    }

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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt == null ? null : createAt.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", createAt='" + createAt + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}