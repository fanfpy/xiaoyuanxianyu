package top.fanfpy.xiaoyuanxianyu.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author fanfp
 * @date 2018/5/11
 * */
public class GoodsInfoVO {

    private Integer goodsId;

    private Integer userId;

    private String userName;

    private String userImg;

    private String goodsTitlie;

    private BigDecimal price;

    @JsonProperty("date")
    private String updateTime;


    private Integer pageView;

    private Byte status;

    private String describle;

    List<String> GoodsImgList;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getGoodsTitlie() {
        return goodsTitlie;
    }

    public void setGoodsTitlie(String goodsTitlie) {
        this.goodsTitlie = goodsTitlie;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public List<String> getGoodsImgList() {
        return GoodsImgList;
    }

    public void setGoodsImgList(List<String> goodsImgList) {
        GoodsImgList = goodsImgList;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }
}
