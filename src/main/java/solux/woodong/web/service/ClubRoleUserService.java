package solux.woodong.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUser;
import solux.woodong.web.domain.clubRoleUser.ClubRoleUserRepository;
import solux.woodong.web.dto.clubRoleUser.ClubRoleUserResponseDto;
import solux.woodong.web.dto.clubRoleUser.ClubRoleUserSaveDto;

@RequiredArgsConstructor
@Service
public class ClubRoleUserService {
    private final ClubRoleUserRepository clubRoleUserRepository;

    @Transactional
    public Long save(ClubRoleUserSaveDto dto) {
        return clubRoleUserRepository.save(dto.toEntity()).getId();
    }

    public ClubRoleUserResponseDto findById(Long id) {
        ClubRoleUser entity = clubRoleUserRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 클럽 롤 유저 없음"));
        return new ClubRoleUserResponseDto(entity);
    }
}
