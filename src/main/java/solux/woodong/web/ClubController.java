package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.role.Roles;
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

    @GetMapping("/api/udong/club/role/{clubId}")
    public List<Roles> getClubRole(@PathVariable Long clubId) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("해당 클럽에 user 없음"));
        List<ClubRole> clubRoles = club.getClubRoles();
        List<Roles> roles = new ArrayList<>();
        for (int i = 0; i < clubRoles.size(); i++) {
            ClubRole entity = clubRoles.get(i);
            Roles role = entity.getRoles();
            roles.add(role);
        }
        return roles;
    }

    @GetMapping("/api/udong/club/clubCode/check/{clubCode}")
    public boolean checkClubCode(@PathVariable String clubCode) {
        List<Club> clubs = clubRepository.findAll();
        boolean check = false;
        for (Club club : clubs) {
            if (clubCode.equals(club.getClubCode())) {
                check = true;
            }
        }
        return check;
    }

    @GetMapping("/api/udong/club/clubCode/{clubCode}")
    public Club findClub(@PathVariable String clubCode) {
        List<Club> clubs = clubRepository.findAll();
        Club result = new Club();
        for (Club club : clubs) {
            if (clubCode.equals(club.getClubCode())) {
                result = club;
                return result;
            }
        }
        return null;
    }

    @DeleteMapping("/api/udong/club/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubService.delete(id);
    }
}
