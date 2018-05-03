package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.Comments;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.repository.CommentsRepository;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsRepository;
import top.fanfpy.xiaoyuanxianyu.service.CommentsService;

import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Comments addComment(Comments comments) {
        goodsRepository.addCommentNum(comments.getGoodsId());
        return commentsRepository.save(comments);
    }

    @Override
    public void delCommrent(Integer id) {
        commentsRepository.deleteById(id);
    }
}
