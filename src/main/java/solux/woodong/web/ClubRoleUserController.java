package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import solux.woodong.web.config.auth.dto.SessionUser;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubRole.ClubRoleRepository;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.clubRoleUser.ClubRoleUserSaveDto;
import solux.woodong.web.dto.user.UserResponseDto;
import solux.woodong.web.service.ClubRoleUserService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class ClubRoleUserController {
    private final HttpSession httpSession;
    private final ClubRoleUserService clubRoleUserService;
    private final ClubRoleRepository clubRoleRepository;
    private final UserRepository userRepository;

    @GetMapping("/api/udong/clubRoleUser/{userId}/{clubRole_Id}")
    public Long save(@PathVariable Long userId, @PathVariable Long clubRole_Id) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유저 오류"));
        ClubRole clubRole = clubRoleRepository.findById(clubRole_Id)
                .orElseThrow(()->new IllegalArgumentException("오류"));
        ClubRoleUserSaveDto saveDto = ClubRoleUserSaveDto.builder()
                    .clubRole(clubRole)
                    .user(user)
                    .build();

        return clubRoleUserService.save(saveDto);
    }


}
