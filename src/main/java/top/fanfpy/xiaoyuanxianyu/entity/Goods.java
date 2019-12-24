package top.fanfpy.xiaoyuanxianyu.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品表
 * @author fanfp
 * @date 2018/4/23
 * */
@Data
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer classificationId;

    private Integer commetNum;

    private String describle;

    private String name;

    private BigDecimal price;

    private byte status;

    private Integer pageView;

    private String updateTime;

}
