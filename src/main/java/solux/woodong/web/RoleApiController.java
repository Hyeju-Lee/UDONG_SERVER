package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.role.Roles;
import solux.woodong.web.dto.role.RoleResponseDto;
import solux.woodong.web.dto.role.RoleSaveRequestDto;
import solux.woodong.web.dto.role.RoleUpdateRequestDto;
import solux.woodong.web.service.role.RoleService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoleApiController {
    private final RoleService roleService;

    @PostMapping("/api/udong/role")
    public Long save(@RequestBody RoleSaveRequestDto requestDto) {
        return roleService.save(requestDto);
    }

    @PutMapping("/api/udong/role/{id}")
    public Long update(@PathVariable Long id, @RequestBody RoleUpdateRequestDto requestDto) {
        return roleService.update(id, requestDto);
    }

    @GetMapping("/api/udong/role/{id}")
    public RoleResponseDto findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @GetMapping("/api/udong/role")
    public List<Roles> getRoleList() {
        return roleService.findAll();
    }

    @DeleteMapping("/api/udong/role/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);
    }
}
