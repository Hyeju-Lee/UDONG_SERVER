package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import solux.woodong.web.config.auth.dto.SessionUser;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.posts.Post;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.post.PostResponseDto;
import solux.woodong.web.dto.user.UserResponseDto;
import solux.woodong.web.service.post.PostService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/api/udong/user/club/{userId}")
    public List<Club> getUserClub(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("해당 유저 없음"));
        List<ClubUser> clubUsers = user.getClubUsers();
        List<Club> clubs = new ArrayList<>();
        for (int i = 0; i < clubUsers.size(); i++) {
            ClubUser entity = clubUsers.get(i);
            Club club = entity.getClub();
            clubs.add(club);
        }
        return clubs;
    }

}
