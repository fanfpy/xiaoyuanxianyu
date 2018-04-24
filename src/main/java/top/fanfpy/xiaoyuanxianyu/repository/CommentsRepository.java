package top.fanfpy.xiaoyuanxianyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.xiaoyuanxianyu.entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments , Integer> {
}
