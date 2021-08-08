package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import solux.woodong.web.config.auth.dto.SessionUser;
import solux.woodong.web.domain.posts.Post;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.post.PostResponseDto;
import solux.woodong.web.dto.user.UserResponseDto;
import solux.woodong.web.service.post.PostService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final HttpSession httpSession;
    private final UserRepository userRepository;

    @GetMapping("/")
    public UserResponseDto findUser() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            User entity = userRepository.findByEmail(user.getEmail())
                    .orElseThrow();
            return new UserResponseDto(entity);
        }
        return null;
    }

}
