package top.fanfpy.xiaoyuanxianyu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 商品表
 * @author fanfp
 * @date 2018/4/23
 * */
@Entity
@Table(name = "googs")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "对应的用户")
    private Integer userId;

    @NotNull(message = "商品所在分类")
    private Integer classificationId;

    @NotNull(message = "商品名称")
    private String name;

    @NotNull(message = "价格")
    @Column(name = "price" ,precision = 11,scale = 2)
    private Float price;


    @NotNull(message = "评论数量")
    private Integer commetNum;

    @NotNull(message = "详细信息")
    private String describle;

    public Goods(){};

    public Goods(@NotNull(message = "商品所在分类") Integer classificationId, @NotNull(message = "对应的用户") Integer userId, @NotNull(message = "商品名称") String name, @NotNull(message = "价格") Float price, @NotNull(message = "创建时间") String startTime, @NotNull(message = "擦亮时间") String polishTime, @NotNull(message = "评论数量") Integer commetNum, @NotNull(message = "详细信息") String describle) {
        this.classificationId = classificationId;
        this.userId = userId;
        this.name = name;
        this.price = price;
        this.commetNum = commetNum;
        this.describle = describle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    public Integer getCommetNum() {
        return commetNum;
    }

    public void setCommetNum(Integer commetNum) {
        this.commetNum = commetNum;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", classificationId=" + classificationId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", commetNum=" + commetNum +
                ", describle='" + describle + '\'' +
                '}';
    }
}