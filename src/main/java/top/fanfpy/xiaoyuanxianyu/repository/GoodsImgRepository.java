package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;

import java.util.List;

public interface GoodsImgRepository extends JpaRepository<GoodsImg,Integer> {
    List<GoodsImg> findByGoodsId(Integer goodsId);
}
