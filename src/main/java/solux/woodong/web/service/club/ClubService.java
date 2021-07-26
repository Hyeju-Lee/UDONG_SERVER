package solux.woodong.web.service.club;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.dto.club.ClubResponseDto;
import solux.woodong.web.dto.club.ClubSaveRequestDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClubService {
    private final ClubRepository clubRepository;

    @Transactional
    public Long save(ClubSaveRequestDto requestDto) {
        return clubRepository.save(requestDto.toEntity()).getId();
    }

    public ClubResponseDto findById (Long id) {
        Club entity = clubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("동아리 없음. id="+id));
        return new ClubResponseDto(entity);
    }

    public List<Club> findAll() {return clubRepository.findAll();}

    public void delete(Long id) {clubRepository.deleteById(id);}
}
