package top.fanfpy.xiaoyuanxianyu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;



public interface GoodsRepository extends JpaRepository<Goods , Integer> {
    /**
     * @param id
     * 原生sql加nativeQuery = true
     */
    @Query(value = "update goods set commet_num = commet_num+1 where id =?1",nativeQuery = true)
    void addCommentNum(Integer id);


}
