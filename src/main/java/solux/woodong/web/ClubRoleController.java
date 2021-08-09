package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.role.RoleRepository;
import solux.woodong.web.domain.role.Roles;
import solux.woodong.web.dto.clubRole.ClubRoleResponseDto;
import solux.woodong.web.dto.clubRole.ClubRoleSaveDto;
import solux.woodong.web.dto.role.RoleSaveRequestDto;
import solux.woodong.web.service.ClubRoleService;
import solux.woodong.web.service.role.RoleService;

@RequiredArgsConstructor
@RestController
public class ClubRoleController {
    private final ClubRoleService clubRoleService;
    private final ClubRepository clubRepository;
    private final RoleRepository roleRepository;
    private final RoleService roleService;

    @PostMapping("/api/udong/clubRole/{clubId}") //role저장하면서 바로 club과 매핑
    public Long save(@PathVariable Long clubId, @RequestBody RoleSaveRequestDto requestDto) {
        Long roleId = roleService.save(requestDto);
        Roles roles = roleRepository.findById(roleId)
                .orElseThrow(()->new IllegalArgumentException("해당 role 없음"));
        Club club = clubRepository.findById(clubId)
                .orElseThrow(()->new IllegalArgumentException("해당 club 없음"));
        ClubRoleSaveDto saveDto = ClubRoleSaveDto.builder()
                .club(club)
                .roles(roles)
                .build();
        return clubRoleService.save(saveDto);
    }

    @GetMapping("/api/udong/clubRole/{id}")
    public ClubRoleResponseDto findById(@PathVariable Long id) {
        return clubRoleService.findById(id);
    }
}
