package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.Comments;

import java.util.List;

/**
 * @author fanfp
 * @date 18/4/23
 * */
public interface CommentsService {
    /**
     *增加评论 商品品论字段下自增1
     * @return 返回评论
     * @param comments 评论
     * */
    Comments addComment(Comments comments);

    /**
     * 删除评论
     * @param id 评论id
     * */
    void delComment(Integer id);

    /**
     * @param goodsId 商品id
     * @return 评论
     * */
    List<Comments> getCommentByGoodsId(Integer goodsId);
}
