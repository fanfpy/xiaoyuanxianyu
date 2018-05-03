package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.Comments;

/**
 * @author fanfp
 * @date 18/4/23
 * */
public interface CommentsService {
    /**
     *增加评论 商品品论字段下自增1
     * @param comments 评论
     * */
    Comments addComment(Comments comments);

    /**
     * 删除评论
     * */
    void delCommrent(Integer id);
}
