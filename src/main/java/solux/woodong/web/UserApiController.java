package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import solux.woodong.web.config.auth.dto.SessionUser;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.role.Roles;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.user.UserResponseDto;

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
    public List<Club> getUsersClub(@PathVariable Long userId) {
            User user = userRepository.findById(userId).orElseThrow();
            List<ClubUser> clubUsers = user.getClubUsers();
            List<Club> clubs = new ArrayList<>();
            for (int i = 0; i < clubUsers.size(); i++) {
                ClubUser entity = clubUsers.get(i);
                Club club = entity.getClub();
                clubs.add(club);
            }
            return clubs;
    }

    @GetMapping("/api/udong/user/clubRole/{userId}/{clubId}") //user, club 정보로 role조회
    public Roles getClubRoles(@PathVariable Long userId, @PathVariable Long clubId) {
        User entity = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("해당 유저 없음"));
        List<ClubRoleUser> clubRoleUsers = entity.getClubRoleUsers();
        ClubRole clubRole = null;
        for (int i = 0; i < clubRoleUsers.size(); i++) {
            ClubRoleUser clubRoleUser = clubRoleUsers.get(i);
            clubRole = clubRoleUser.getClubRole();
            Club club = clubRole.getClub();
            if(club.getId() == clubId)
                break;

        }
        return clubRole.getRoles();
    }

}
