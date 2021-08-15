package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.clubUser.ClubUserResponseDto;
import solux.woodong.web.dto.clubUser.ClubUserSaveDto;
import solux.woodong.web.service.ClubUserService;

@RequiredArgsConstructor
@RestController
public class ClubUserController {
    private final ClubUserService clubUserService;

    private final ClubRepository clubRepository;

    private final UserRepository userRepository;

    @GetMapping("/api/udong/clubUser/{clubId}/{userId}") //club과 user mapping
    public Long save(@PathVariable Long clubId, @PathVariable Long userId) {
        Club club = clubRepository.findById(clubId).orElseThrow(
                ()->new IllegalArgumentException("오류"));
        User user = userRepository.findById(userId).orElseThrow(
                ()->new IllegalArgumentException("오류"));
        ClubUserSaveDto saveDto = ClubUserSaveDto.builder()
                .user(user)
                .club(club)
                .build();
        return clubUserService.save(saveDto);
    }

    @GetMapping("/api/udong/clubUser/teamNumber/{id}/{teamNumber}") //set teamNumber
    public Long update(@PathVariable Long id, @PathVariable int teamNumber) {
        return clubUserService.update(id, teamNumber);
    }

    @GetMapping("/api/udong/clubUser/{id}")
    public ClubUserResponseDto findById (@PathVariable Long id) {
        return clubUserService.findById(id);
    }
}
