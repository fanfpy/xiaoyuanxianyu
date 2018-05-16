package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Comments;

import java.util.List;

/**
 * @author fanfp
 * @date 2018/5.16
 * */
public interface CommentsRepository extends JpaRepository<Comments , Integer> {

    /**
     * @param goodsId 商品id
     * @return 返回评论表
     * */
    List<Comments> findAllByGoodsId(Integer goodsId);
}
