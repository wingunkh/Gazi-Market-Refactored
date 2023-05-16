package capstone.capstone.repository;

import capstone.capstone.domain.Like_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeListRepository extends JpaRepository<Like_list, Integer> {
    @Query(value="select L.post_num from Like_list L where L.user_num = :user_num and L.status != '숨김'" , nativeQuery = true)
    List<Integer> findbyuser(@Param("user_num") int user_num);
}