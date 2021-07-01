package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.dto.post.PostResponseDto;
import solux.woodong.web.dto.post.PostSaveRequestDto;
import solux.woodong.web.dto.post.PostUpdateRequestDto;
import solux.woodong.web.service.post.PostService;

@RequiredArgsConstructor //생성자를 통해 bean 주입(스프링 컨테이너에 있는 postService를 controller에 연결시켜줌)
@RestController //controller는 view를 반환하기 위해 쓰는 것이고 restcontroller는 controller + responseBody로 json 데이터 반환
public class PostApiController {
    private final PostService postService;

    //클라이언트에서 서버로 json데이터를 담아 보내면 서버에서 requestBody를 이용해 이를 자바 객체로 변환시켜 저장
    //서버에서 클라이언트로 응답 데이터를 전송하기 위해 responseBody를 사용하여 자바 객체를 json으로 변환하여 전송
    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto findById (@PathVariable Long id) {
        return postService.findById(id);
    }
}
