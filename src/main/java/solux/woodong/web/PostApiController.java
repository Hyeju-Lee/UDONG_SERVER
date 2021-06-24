package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import solux.woodong.web.dto.PostSaveRequestDto;
import solux.woodong.web.service.post.PostService;

@RequiredArgsConstructor //생성자를 통해 bean 주입(스프링 컨테이너에 있는 postService를 controller에 연결시켜줌)
@RestController //controller는 view를 반환하기 위해 쓰는 것이고 restcontroller는 controller + responseBody로 데이터 반환
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }
}
