package top.fanfpy.xiaoyuanxianyu.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


    /**
     * 通过商品id获取评论
     * */
    @GetMapping(value = "/{goodId}")
    public ResultVO getCommentsByGoodsId(@PathVariable("goodId") Integer goodId){
        //评论数量
        List<Comments> commentsList = commentsService.getCommentByGoodsId(goodId);


        List<CommentsInfoVO> commentsInfoVOList = new ArrayList<>();

        for (Comments comment:commentsList) {
            User user = userService.finaUserId(comment.getUserId()).get();
            commentsInfoVOList.add(new CommentsInfoVO(comment.getId(),user.getUserImg(),  user.getUsername(), comment.getContent(), comment.getDate()));
        }
        return ResultUtils.success(commentsInfoVOList);
    }

    @PostMapping("/")
    public void saveComments(Comments comments){
        commentsService.addComment(comments);
    }

    @DeleteMapping("/{Commentsid}")
    public void delComments(@PathVariable Integer Commentsid){
        commentsService.delComment(Commentsid);
    }
}
