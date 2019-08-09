package top.fanfpy.xiaoyuanxianyu.vo;

/**
 * @author fanfpy
 * @date 2018/5/19
 * */
public class UserInfoVO {
    private Integer userId;

    private String userNmae;

    private String  userImg;

    private String userEmail;

    private String userPhone;

    private Integer goodsNum;

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "userId=" + userId +
                ", userNmae='" + userNmae + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", goodsNum=" + goodsNum +
                '}';
    }
}
