package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.VO.GoodsInfoVO;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;
import top.fanfpy.xiaoyuanxianyu.entity.Goods;
import top.fanfpy.xiaoyuanxianyu.entity.GoodsImg;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.repository.ClassificationRepository;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsImgRepository;
import top.fanfpy.xiaoyuanxianyu.repository.GoodsRepository;
import top.fanfpy.xiaoyuanxianyu.repository.UserRepository;
import top.fanfpy.xiaoyuanxianyu.service.GoodsSrevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
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
    @Autowired
    private GoodsImgRepository goodsImgRepository;

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
        user.setGoodsNum(user.getGoodsNum()+1);
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
    public Page<Goods> findByHotGoods(Integer start,Integer size) {
        //分页方法
        Pageable pageable =PageRequest.of(start,size,Sort.Direction.DESC,"PageView");
        return goodsRepository.findAll(pageable);
    }

    @Override
    public Page<Goods> findByNewGoods(Integer start, Integer size) {
        Pageable pageable =PageRequest.of(start,size,Sort.Direction.DESC,"Id");
        return goodsRepository.findAll(pageable);
    }

    @Override
    public GoodsInfoVO GoodsInfo(Integer goodsId, Integer imgNum) {
        /**
         * @date 2018/6/6
         * 创建goodsInfo对象 通过商品id获取 goods对象 获取 商品图片
         * 通过goods 获取 用户id 获取用户名 头像
         * 然后一次添加到GoodsInfo
         */
        GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
        List<String> stringList = new ArrayList<>();

        //查询对应的商品
        Goods goods = goodsRepository.findById(goodsId).get();
        //对应的用户
        User user = userRepository.findById(goods.getUserId()).get();

        //对应商品的图片
        List<GoodsImg> goodsImgList = goodsImgRepository.findByGoodsId(goodsId);

        for (GoodsImg goodsImg : goodsImgList){
            stringList.add(goodsImg.getImgUrl());
            if (stringList.size()>=imgNum){
                break;
            }
        }
        goodsInfoVO.setGoodsId(goods.getId());
        goodsInfoVO.setUserId(goods.getUserId());
        goodsInfoVO.setUserName(user.getUsername());
        goodsInfoVO.setUserImg(user.getUserImg());
        goodsInfoVO.setGoodsTitle(goods.getName());
        goodsInfoVO.setPrice(goods.getPrice());
        goodsInfoVO.setPageView(goods.getPageView());
        goodsInfoVO.setStatus(goods.getStatus());
        goodsInfoVO.setDescrible(goods.getDescrible());
        goodsInfoVO.setUpdateTime(goods.getUpdateTime());
        goodsInfoVO.setGoodsImgList(stringList);

        return goodsInfoVO;
    }
}
