package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.notice.Notice;
import solux.woodong.web.dto.notice.NoticeResponseDto;
import solux.woodong.web.dto.notice.NoticeSaveRequestDto;
import solux.woodong.web.dto.notice.NoticeUpdateRequestDto;
import solux.woodong.web.service.notice.NoticeService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {
    private final NoticeService noticeService;

    @PostMapping("/api/udong/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto) {return noticeService.save(requestDto);}

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
        noticeService.delete(id);
    }


}
