package solux.woodong.web.service.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.role.RoleRepository;
import solux.woodong.web.domain.role.Roles;
import solux.woodong.web.dto.role.RoleResponseDto;
import solux.woodong.web.dto.role.RoleSaveRequestDto;
import solux.woodong.web.dto.role.RoleUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Transactional
    public Long save(RoleSaveRequestDto requestDto) {
        return roleRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, RoleUpdateRequestDto requestDto) {
        Roles roles = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 role 없음 id"+id));
        roles.update(requestDto.getName(), requestDto.isNotice_auth());
        return id;
    }

    public RoleResponseDto findById(Long id) {
        Roles entity = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 role 없음 id"+id));
        return new RoleResponseDto(entity);
    }

    public List<Roles> findAll() {return roleRepository.findAll();}

    @Transactional
    public void delete(Long id) {
        Roles entity = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 role 없음 id"+id));
        roleRepository.delete(entity);
    }
}
