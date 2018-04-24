package top.fanfpy.xiaoyuanxianyu.service;

import top.fanfpy.xiaoyuanxianyu.entity.Classification;

import java.util.List;

/**
 * @author fanfp
 * @date 18/4/23
 * */
public interface ClassificationService {
    /**
     * 返回分类列表
     * @return 返回分类列表
     * */
    List<Classification> listClassification();

    /**
     * @param classification 分类
     * @return 返回增加列表的信息
     * */
    Classification addClassification(Classification classification);

    /**通过id删除分类
     * @param id 分类id
     * */
    void delClassification(Integer id);

    /**
     * @param classification 分类
     * @return 返回修改的信息
     * */
    Classification updateClassification(Classification classification);
}
