package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.repository.ClassificationRepository;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsRepository;
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

    @Override
    public void delGoods(Integer id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Goods addGood(Goods goods) {

        //当前分类
        Optional<Classification> classification = classificationRepository.findById(goods.getClassificationId());
        Classification classification1 = new Classification();
        classification1.setId(classification.get().getId());
        classification1.setName(classification.get().getName());
        classification1.setStatus(classification.get().getStatus());
        classification1.setNumber(classification.get().getNumber()+1);
        classificationRepository.save(classification1);
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
