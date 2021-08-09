package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.domain.notice.NoticeRepository;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.notice.NoticeResponseDto;
import solux.woodong.web.dto.notice.NoticeSaveRequestDto;
import solux.woodong.web.dto.notice.NoticeUpdateRequestDto;
import solux.woodong.web.service.notice.NoticeService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {
    private final NoticeService noticeService;

    private final NoticeRepository noticeRepository;

    private final ClubRepository clubRepository;
    private final UserRepository userRepository;

    @PostMapping("/api/udong/notice/{club_id}/{userId}")
    public Long save(@PathVariable Long club_id, @PathVariable Long userId,
                     @RequestBody NoticeSaveRequestDto requestDto) {
        Club clubNotice = clubRepository.findById(club_id).orElseThrow(
                ()->new IllegalArgumentException("클럽 오류"));
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유저 오류"));
        requestDto = NoticeSaveRequestDto.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .club(clubNotice)
                .user(user)
                .build();
        return noticeService.save(requestDto);
    }

    @PutMapping("/api/udong/notice/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeUpdateRequestDto requestDto) {
        return noticeService.update(id, requestDto);
    }

    @GetMapping("/api/udong/notice/{id}")
    public NoticeResponseDto findById (@PathVariable Long id) {return noticeService.findById(id);}

    @GetMapping("/api/udong/notice")
    public List<Notice> getNoticeList() {
        return noticeService.findAll();
    }

    @DeleteMapping("/api/udong/notice/{id}")
    public void deleteNotice(@PathVariable Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 notice 없음"));
        notice = Notice.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .author(notice.getAuthor())
                .club(null).build();
        noticeService.delete(id);
    }


}
