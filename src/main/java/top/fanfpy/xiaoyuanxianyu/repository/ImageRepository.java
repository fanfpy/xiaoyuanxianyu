package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.fanfpy.xiaoyuanxianyu.entity.Image;

public interface ImageRepository extends JpaRepository<Image , Integer> {

}
