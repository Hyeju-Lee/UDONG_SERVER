package solux.woodong.web.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.posts.Post;
import solux.woodong.web.domain.posts.PostRepository;
import solux.woodong.web.dto.post.PostResponseDto;
import solux.woodong.web.dto.post.PostSaveRequestDto;
import solux.woodong.web.dto.post.PostUpdateRequestDto;

@RequiredArgsConstructor   //생성자를 생성하여 이를 통해 스프링 bean을 주입 (스프링 컨테이너에 있는 postservice에 postrepository 연결)
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostResponseDto findById (Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostResponseDto(entity);
    }
}
