package top.fanfpy.xiaoyuanxianyu.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author fanfp
 * */
@Data
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

}
