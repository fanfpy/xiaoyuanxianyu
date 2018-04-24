package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.fanfpy.xiaoyuanxianyu.entity.Comments;
import top.fanfpy.xiaoyuanxianyu.repository.CommentsRepository;
import top.fanfpy.xiaoyuanxianyu.service.CommentsService;

public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Comments addComment(Comments comments) {
        return commentsRepository.save(comments);
    }

    @Override
    public void delCommrent(Integer id) {
        commentsRepository.deleteById(id);
    }
}
