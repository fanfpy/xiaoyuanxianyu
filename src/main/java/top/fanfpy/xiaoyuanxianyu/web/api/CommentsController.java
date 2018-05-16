package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanfpy.xiaoyuanxianyu.VO.CommentsInfoVO;
import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;
import top.fanfpy.xiaoyuanxianyu.entity.Comments;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.service.CommentsService;
import top.fanfpy.xiaoyuanxianyu.service.UserService;
import top.fanfpy.xiaoyuanxianyu.utils.ResultUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论相关
 * @author fanfp
 * @date 2018/5/16
 * */
@RestController
@RequestMapping(value = "api/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;
    @Autowired
    UserService userService;


    @GetMapping(value = "/{goodId}")
    public ResultVO getCommentsByGoodsId(@PathVariable("goodId") Integer goodId){
        //评论数量
        List<Comments> commentsList = commentsService.getCommentByGoodsId(goodId);
        //
        List<CommentsInfoVO> commentsInfoVOList = new ArrayList<>();

        for (Comments comment:commentsList) {
            User user = userService.finaUserId(comment.getUserId()).get();
            commentsInfoVOList.add(new CommentsInfoVO(user.getUserImg(), comment.getUserId(), user.getUsername(), comment.getContent(), comment.getDate()));
        }
        return ResultUtils.success(commentsInfoVOList);
    }
}
