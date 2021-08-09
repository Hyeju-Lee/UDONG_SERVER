package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.posts.Post;
import solux.woodong.web.domain.posts.PostRepository;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.post.PostResponseDto;
import solux.woodong.web.dto.post.PostSaveRequestDto;
import solux.woodong.web.dto.post.PostUpdateRequestDto;
import solux.woodong.web.service.post.PostService;

import java.util.List;

@RequiredArgsConstructor //생성자를 통해 bean 주입(스프링 컨테이너에 있는 postService를 controller에 연결시켜줌)
@RestController //controller는 view를 반환하기 위해 쓰는 것이고 restcontroller는 controller + responseBody로 json 데이터 반환
public class PostApiController {
    private final PostService postService;

    private final PostRepository postRepository;

    private final ClubRepository clubRepository;
    private final UserRepository userRepository;

    //클라이언트에서 서버로 json데이터를 담아 보내면 서버에서 requestBody를 이용해 이를 자바 객체로 변환시켜 저장
    //서버에서 클라이언트로 응답 데이터를 전송하기 위해 responseBody를 사용하여 자바 객체를 json으로 변환하여 전송
    @PostMapping("/api/udong/post/{club_id}/{userId}")
    public Long save(@PathVariable Long club_id, @PathVariable Long userId
            , @RequestBody PostSaveRequestDto requestDto) {
        Club clubPost = clubRepository.findById(club_id)
                .orElseThrow(() -> new IllegalArgumentException("error"));
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유저 오류"));
        requestDto = PostSaveRequestDto.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .teamNumber(requestDto.getTeamNumber())
                .club(clubPost)
                .user(user)
                .build();
        return postService.save(requestDto);
    }

    @PutMapping("/api/udong/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/udong/post/{id}")
    public PostResponseDto findById (@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/api/udong/post")
    public List<Post> getPostList() {
        return postService.findAll();
    }

    @DeleteMapping("/api/udong/post/{id}")
    public void deletePost(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("notice 없음"));
        post = Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .teamNumber(post.getTeamNumber())
                .club(null).build();
        postService.delete(id);
    }

}
