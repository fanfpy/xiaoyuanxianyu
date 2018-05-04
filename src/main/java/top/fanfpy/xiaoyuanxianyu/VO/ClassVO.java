package top.fanfpy.xiaoyuanxianyu.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * 商品（包含类目）
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
    private List<GoodsVO> goodsList;


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

    public List<GoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVO> goodsList) {
        this.goodsList = goodsList;
    }
}
