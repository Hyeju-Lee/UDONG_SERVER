package solux.woodong.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {  //dao
// 게시글 save, findAll 등의 역할 수행
}
