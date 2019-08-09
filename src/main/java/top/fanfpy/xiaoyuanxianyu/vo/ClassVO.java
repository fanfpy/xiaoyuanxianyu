package top.fanfpy.xiaoyuanxianyu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * 商品（包含类目）
 * 通过分类id 获取所在分类下的商品
 * @author fanfp
 * @date 2018/5/4
 * */
public class ClassVO {

    @JsonProperty("id")
    private Integer classificationId;

    @JsonProperty("name")
    private String classificationName;

    @JsonProperty("status")
    private Byte classificationStatus;

    @JsonProperty("goods")
    private List<GoodsInfoVO> goodsList;


    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public Byte getClassificationStatus() {
        return classificationStatus;
    }

    public void setClassificationStatus(Byte classificationStatus) {
        this.classificationStatus = classificationStatus;
    }

    @Override
    public String toString() {
        return "ClassVO{" +
                "classificationId=" + classificationId +
                ", classificationName='" + classificationName + '\'' +
                ", classificationStatus=" + classificationStatus +
                ", goodsList=" + goodsList +
                '}';
    }
}

