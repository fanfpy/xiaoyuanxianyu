package top.fanfpy.xiaoyuanxianyu.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * 分类表
 * @author fanfp
 * @date 2018/4/22
 * */
@Data
@Entity(name = "classification")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "分类名")
    @Length(max = 10)
    private String name;

    @NotNull(message = "该分类下商品数量")
    private Integer number;

    @NotNull(message = "状态0 正常 1暂停")
    private Byte status;

    public Classification(){
    }

    public Classification(@NotNull(message = "分类名") @Length(max = 10) String name, @NotNull(message = "该分类下商品数量") Integer number, @NotNull(message = "状态0 正常 1暂停") Byte status) {
        this.name = name;
        this.number = number;
        this.status = status;
    }
}
