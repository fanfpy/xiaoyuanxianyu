package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.repository.ClassificationRepository;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsRepository;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author fanfp
 * */
@Service
public class GoodsServiceImpl implements GoodsSrevice {


    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private ClassificationRepository classificationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Goods> listGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public void delGoods(Integer id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Goods saveGood(Goods goods) {
        //取出对应的类目
        Classification classification = classificationRepository.findById(goods.getClassificationId()).get();
        //字段加1
        classification.setNumber(classification.getNumber()+1);
        classificationRepository.save(classification);

        //取出对应字段的用户
        User user= userRepository.findById(goods.getUserId()).get();
        //加一
        user.setGoodsNum(goods.getUserId()+1);
        userRepository.save(user);
        return goodsRepository.save(goods);
    }

    @Override
    public Goods upGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Page<Goods> findAll(Pageable pageable) {
        return goodsRepository.findAll(pageable);
    }

    @Override
    public List<Goods> findallGood() {
        return goodsRepository.findAll();
    }

    @Override
    public Optional<Goods> findById(Integer id) {
        return goodsRepository.findById(id);
    }

    @Override
    public List<Goods> findByClassifiaction(Integer classifiactionId) {
        return goodsRepository.findByClassificationId(classifiactionId);
    }


    @Override
    public Page<Goods> findByHotGoods(Integer page , Integer num) {
        Pageable pageable =new PageRequest(page,num,Sort.Direction.DESC,"PageView");
        return goodsRepository.findAll(pageable);
    }
}
