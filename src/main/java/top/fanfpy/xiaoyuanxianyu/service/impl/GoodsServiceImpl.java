package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.repository.ClassificationRepository;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsRepository;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class GoodsServiceImpl implements GoodsSrevice {


    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private ClassificationRepository classificationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void delGoods(Integer id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Goods addGood(Goods goods) {
        classificationRepository.addNumber(goods.getClassificationId());
        userRepository.addGoodsNum(goods.getUserId());
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
}
