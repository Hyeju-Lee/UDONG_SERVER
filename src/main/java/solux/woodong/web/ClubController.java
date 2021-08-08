package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.dto.club.ClubResponseDto;
import solux.woodong.web.dto.club.ClubSaveRequestDto;
import solux.woodong.web.service.club.ClubService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClubController {
    private final ClubService clubService;
    private final ClubRepository clubRepository;

    @PostMapping("/api/udong/club")
    public Long save(@RequestBody ClubSaveRequestDto requestDto) {
        return clubService.save(requestDto);
    }

    @GetMapping("/api/udong/club/{id}")
    public ClubResponseDto findById(@PathVariable Long id) {
        return clubService.findById(id);
    }

    @GetMapping("/api/udong/club")
    public List<Club> getClubList() {
        return clubService.findAll();
    }

    @GetMapping("/api/udong/club/user/{clubId}")
    public List<User> getClubUser(@PathVariable Long clubId) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(()-> new IllegalArgumentException("해당 클럽에 user 없음"));
        List<ClubUser> clubUsers = club.getClubUsers();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < clubUsers.size(); i++) {
            ClubUser entity = clubUsers.get(i);
            User user = entity.getUser();
            users.add(user);
        }
        return users;
    }

    @DeleteMapping("/api/udong/club/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubService.delete(id);
    }
}
