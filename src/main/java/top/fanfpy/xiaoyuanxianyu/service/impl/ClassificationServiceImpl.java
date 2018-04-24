package top.fanfpy.xiaoyuanxianyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.xiaoyuanxianyu.entity.Classification;
import top.fanfpy.xiaoyuanxianyu.repository.ClassificationRepository;
import top.fanfpy.xiaoyuanxianyu.service.ClassificationService;

import java.util.List;
/**
 * @author fanfp
 * @date 18/4/23
 * */
@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    ClassificationRepository classificationRepository;
    @Override
    public List<Classification> listClassification() {
        return classificationRepository.findAll();
    }

    @Override
    public Classification addClassification(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Override
    public void delClassification(Integer id) {
        classificationRepository.deleteById(id);
    }

    @Override
    public Classification updateClassification(Classification classification) {
    return classificationRepository.save(classification);
    }
}
