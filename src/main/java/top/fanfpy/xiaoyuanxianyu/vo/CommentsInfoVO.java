package top.fanfpy.xiaoyuanxianyu.vo;

public class CommentsInfoVO {


    private Integer commentsId;

     private String userImg;

     private String commentsUserName;

    private String comments;

    private String commentsTime;


    public CommentsInfoVO() { }

    public CommentsInfoVO(Integer commentsId, String userImg, String commentsUserName, String comments, String commentsTime) {
        this.commentsId = commentsId;
        this.userImg = userImg;
        this.commentsUserName = commentsUserName;
        this.comments = comments;
        this.commentsTime = commentsTime;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public String getCommentsUserName() {
        return commentsUserName;
    }

    public void setCommentsUserName(String commentsUserName) {
        this.commentsUserName = commentsUserName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(String commentsTime) {
        this.commentsTime = commentsTime;
    }

    @Override
    public String toString() {
        return "CommentsInfoVO{" +
                "commentsId=" + commentsId +
                ", userImg='" + userImg + '\'' +
                ", commentsUserName='" + commentsUserName + '\'' +
                ", comments='" + comments + '\'' +
                ", commentsTime='" + commentsTime + '\'' +
                '}';
    }
}
