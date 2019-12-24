package top.fanfpy.xiaoyuanxianyu.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author fanfpy
 * @date 2018/4/23
 * */
@Data
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


}
