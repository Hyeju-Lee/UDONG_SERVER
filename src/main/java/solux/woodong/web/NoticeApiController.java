package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import solux.woodong.web.dto.notice.NoticeSaveRequestDto;
import solux.woodong.web.service.notice.NoticeService;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {
    private final NoticeService noticeService;

    @PostMapping("/api/udong/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto) {return noticeService.save(requestDto);}
}
