package top.fanfpy.xiaoyuanxianyu.entity;

import javax.persistence.*;

/**
 * @author fanfp
 * */
@Entity
@Table(name = "goods_img")
public class GoodsImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer goodsId;

    private String imgUrl;

    public GoodsImg() {
    }

    public GoodsImg(Integer goodsId, String imgUrl) {
        this.goodsId = goodsId;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
