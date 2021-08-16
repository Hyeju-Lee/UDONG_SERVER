package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.clubUser.ClubUserRepository;
import solux.woodong.web.domain.role.Roles;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.user.IdTokenSaveDto;
import solux.woodong.web.dto.user.UserResponseDto;
import solux.woodong.web.dto.user.UserSaveDto;
import solux.woodong.web.service.WebClientService;
import solux.woodong.web.service.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    //private final HttpSession httpSession;
    private final UserRepository userRepository;
    private final WebClientService webClientService;
    private final UserService userService;
    private final ClubUserRepository clubUserRepository;

    /*@GetMapping("/")
    public UserResponseDto findUser() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            User entity = userRepository.findByEmail(user.getEmail())
                    .orElseThrow();
            return new UserResponseDto(entity);
        }
        return null;
    }*/

    @PostMapping("/api/udong/idToken") //idToken 받아와서 user로 저장(user id를 string 형식으로 return 하게 함)
    public String getIdToken(@RequestBody IdTokenSaveDto idTokenSaveDto) {
        String idToken = idTokenSaveDto.getIdToken();
        String response = webClientService.getUser(idToken);
        JSONParser parser = new JSONParser();
        UserSaveDto userSaveDto = null;
        try {
            Object obj = parser.parse(response);
            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            String email = (String) jsonObject.get("email");
            if (!userRepository.findByEmail(email).isPresent()) {
                userSaveDto = UserSaveDto.builder()
                        .name(name)
                        .email(email)
                        .build();
            }
            else {
                User user = userRepository.findByEmail(email)
                        .orElseThrow();
                return user.getId().toString();
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return userService.save(userSaveDto).toString();
    }

    @GetMapping("/api/udong/user/findAll")
    public List<User> getUserList() {
        return userService.findAll();
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

    @GetMapping("/api/udong/user/clubUser/{userId}/{clubId}")
    public Long getClubUserId(@PathVariable Long userId, @PathVariable Long clubId) {
        List<ClubUser> clubUsers = clubUserRepository.findAll();
        for (ClubUser cu : clubUsers) {
            if (cu.getClub().getId() == clubId) {
                if (cu.getUser().getId() == userId) {
                    return cu.getId();
                }
            }
        }
        return 0l;
    }

    @GetMapping("/api/udong/user/teamNumber/{userId}/{clubId}")
    public int getTeamNum(@PathVariable Long userId, @PathVariable Long clubId) {
        List<ClubUser> clubUsers = clubUserRepository.findAll();
        Long clubUserId = 0l;
        for (ClubUser cu : clubUsers) {
            if (cu.getClub().getId() == clubId) {
                if (cu.getUser().getId() == userId) {
                    clubUserId = cu.getId();
                }
            }
        }
        ClubUser clubUser = clubUserRepository.findById(clubUserId)
                .orElseThrow(()->new IllegalArgumentException());
        return clubUser.getTeamNumber();
    }

}
