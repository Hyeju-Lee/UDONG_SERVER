package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.club.ClubRepository;
import solux.woodong.web.domain.receipt.Receipt;
import solux.woodong.web.domain.receipt.ReceiptRepository;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.receipt.ReceiptResponseDto;
import solux.woodong.web.dto.receipt.ReceiptSaveRequestDto;
import solux.woodong.web.dto.receipt.ReceiptUpdateRequestDto;
import solux.woodong.web.service.receipt.ReceiptService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReceiptApiController {
    private final ReceiptService receiptService;

    private final ReceiptRepository receiptRepository;

    private final ClubRepository clubRepository;

    private final UserRepository userRepository;

    @PostMapping("/api/udong/receipt/{club_id}/{userId}")
    public void save(@PathVariable Long club_id, @PathVariable Long userId
            , @RequestBody ReceiptSaveRequestDto[] requestDtos) {
        Club clubReceipt = clubRepository.findById(club_id).orElseThrow(
                ()->new IllegalArgumentException("오류"));
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유저 오류"));
        for (ReceiptSaveRequestDto requestDto : requestDtos) {
            requestDto = ReceiptSaveRequestDto.builder()
                    .cost(requestDto.getCost())
                    .title(requestDto.getTitle())
                    .content(requestDto.getContent())
                    .picture(requestDto.getPicture())
                    .useDate(requestDto.getUseDate())
                    .club(clubReceipt)
                    .user(user).build();
            receiptService.save(requestDto);
        }
    }

    @PostMapping("/api/udong/receipt")
    public void save(@RequestBody ReceiptSaveRequestDto[] requestDtos) {
        for (ReceiptSaveRequestDto requestDto : requestDtos) {
            requestDto = ReceiptSaveRequestDto.builder()
                    .cost(requestDto.getCost())
                    .title(requestDto.getTitle())
                    .content(requestDto.getContent())
                    .picture(requestDto.getPicture())
                    .useDate(requestDto.getUseDate())
                    .club(null)
                    .user(null).build();
            receiptService.save(requestDto);
        }
    }

    @GetMapping("/api/udong/receipt/useDate/{useDate}")
    public List<Receipt> response(@PathVariable String useDate){
        List<Receipt> receipts = receiptRepository.findAll();
        List<Receipt> result = new ArrayList<>();
        for (Receipt receipt : receipts) {
            if (receipt.getUseDate().equals(useDate)) {
                result.add(receipt);
            }
        }
        return result;
    }

    @GetMapping("/api/udong/receipt/useDate/{clubId}/{useDate}")
    public List<Receipt> responseWithUseDate(@PathVariable Long clubId, @PathVariable String useDate) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow();
        List<Receipt> receipts = club.getReceipts();
        List<Receipt> result = new ArrayList<>();
        for (Receipt receipt : receipts) {
            if (useDate.equals(receipt.getUseDate())) {
                result.add(receipt);
            }
        }
        return result;
    }

    @PutMapping("/api/udong/receipt/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReceiptUpdateRequestDto requestDto) {
        return receiptService.update(id, requestDto);
    }

    @GetMapping("/api/udong/receipt/{id}")
    public ReceiptResponseDto findById (@PathVariable Long id) {
        return receiptService.findById(id);
    }

    @GetMapping("/api/udong/receipt")
    public List<Receipt> getReceiptList() {
        return receiptService.findAll();
    }

    @DeleteMapping("/api/udong/receipt/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        Receipt receipt = receiptRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 receipt 없음"+id));
        receipt = Receipt.builder()
                .cost(receipt.getCost())
                .title(receipt.getTitle())
                .content(receipt.getContent())
                .picture(receipt.getPicture())
                .useDate(receipt.getUseDate())
                .club(null).build();
        receiptService.delete(id);
    }
}
