package top.fanfpy.xiaoyuanxianyu.VO;

public class CommentsInfoVO {

     private String userImg;

     private Integer commentsUserId;

     private String commentsUserName;

    private String comments;

    private String commentsTime;


    public CommentsInfoVO() { }

    public CommentsInfoVO(String userImg, Integer commentsUserId, String commentsUserName, String comments, String commentsTime) {
        this.userImg = userImg;
        this.commentsUserId = commentsUserId;
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

    public Integer getCommentsUserId() {
        return commentsUserId;
    }

    public void setCommentsUserId(Integer commentsUserId) {
        this.commentsUserId = commentsUserId;
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
                "userImg='" + userImg + '\'' +
                ", commentsUserId=" + commentsUserId +
                ", commentsUserName='" + commentsUserName + '\'' +
                ", comments='" + comments + '\'' +
                ", commentsTime='" + commentsTime + '\'' +
                '}';
    }
}
