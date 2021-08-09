package solux.woodong.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.clubRole.ClubRole;
import solux.woodong.web.domain.clubRole.ClubRoleRepository;
import solux.woodong.web.dto.clubRole.ClubRoleResponseDto;
import solux.woodong.web.dto.clubRole.ClubRoleSaveDto;

@RequiredArgsConstructor
@Service
public class ClubRoleService {
    private final ClubRoleRepository clubRoleRepository;

    @Transactional
    public Long save(ClubRoleSaveDto dto) {
        return clubRoleRepository.save(dto.toEntity()).getId();
    }

    public ClubRoleResponseDto findById(Long id) {
        ClubRole entity = clubRoleRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 클럽 롤 없음"));
        return new ClubRoleResponseDto(entity);
    }
}
