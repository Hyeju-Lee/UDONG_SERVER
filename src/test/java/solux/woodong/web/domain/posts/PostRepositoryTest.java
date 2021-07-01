package solux.woodong.web.domain.posts;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostRepositoryTest {

    @Autowired
     PostRepository postRepository;

    @After
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "본문";

        postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .author("author")
                .build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2021,5,4,0,0,0);
        postRepository.save(Post.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        System.out.println(">>>>>>>>>>>createDate = " + post.getCreatedDate() + ">>>>>modifiedDate = " + post.getModifiedDate());
        assertThat(post.getCreatedDate()).isAfter(now);
        assertThat(post.getModifiedDate()).isAfter(now);
    }
}