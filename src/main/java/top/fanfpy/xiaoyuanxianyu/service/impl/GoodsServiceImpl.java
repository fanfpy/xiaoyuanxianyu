package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsRepository;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsSrevice {

    @Autowired
    private GoodsRepository goodsRepository;


    @Override
    public Goods addGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void delGoods(Integer id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Goods updateGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Page<Goods> findAll(Pageable pageable) {
        return goodsRepository.findAll(pageable);
    }

//    @Override
//    public Optional<Goods> findByClassificationId(Integer id, Pageable pageable) {
//        return goodsRepository.findById(id,pageable);
//    }


    @Override
    public List<Goods> findallGood() {
        return goodsRepository.findAll();
    }
}
