package solux.woodong.web.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.posts.PostRepository;
import solux.woodong.web.dto.PostSaveRequestDto;

@RequiredArgsConstructor   //생성자를 생성하여 이를 통해 스프링 bean을 주입 (스프링 컨테이너에 있는 postservice에 postrepository 연결)
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }
}
