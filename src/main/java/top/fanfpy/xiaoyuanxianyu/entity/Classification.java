package top.fanfpy.xiaoyuanxianyu.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * 分类表
 * @author fanfp
 * @date 2018/4/22
 * */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", status=" + status +
                '}';
    }
}
