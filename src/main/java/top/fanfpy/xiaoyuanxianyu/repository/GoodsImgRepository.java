package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;

import java.util.List;
/**
 * @author fanfp
 * */
public interface GoodsImgRepository extends JpaRepository<GoodsImg,Integer> {
    /**
     * @param goodsId 商品id
     * @return 返回商品对应的图片
     * */
    List<GoodsImg> findByGoodsId(Integer goodsId, Pageable pageable);

}
