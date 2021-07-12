package solux.woodong.web.service.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.domain.notice.NoticeRepository;
import solux.woodong.web.dto.notice.NoticeResponseDto;
import solux.woodong.web.dto.notice.NoticeSaveRequestDto;
import solux.woodong.web.dto.notice.NoticeUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NoticeUpdateRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없음 id="+id));
        notice.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public NoticeResponseDto findById (Long id) {
        Notice entity = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new NoticeResponseDto(entity);
    }

    public List<Notice> findAll() {return noticeRepository.findAll();}

    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }
}
