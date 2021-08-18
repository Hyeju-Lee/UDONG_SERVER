package solux.woodong.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.clubUser.ClubUser;
import solux.woodong.web.domain.clubUser.ClubUserRepository;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.dto.clubUser.ClubUserResponseDto;
import solux.woodong.web.dto.clubUser.ClubUserSaveDto;
import solux.woodong.web.dto.notice.NoticeUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClubUserService {
    private final ClubUserRepository clubUserRepository;

    @Transactional
    public Long save(ClubUserSaveDto requestDto) {
        return clubUserRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, int teamNumber) {
        ClubUser clubUser = clubUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 clubuser 없음 id="+id));
        clubUser.update(teamNumber);
        return id;
    }

    public ClubUserResponseDto findById(Long id) {
        ClubUser entity = clubUserRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 clubuser없음"));
        return new ClubUserResponseDto(entity);
    }

    public List<ClubUser> findAll() {
        return clubUserRepository.findAll();
    }


}
