package solux.woodong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import solux.woodong.web.domain.receipt.Receipt;
import solux.woodong.web.dto.receipt.ReceiptResponseDto;
import solux.woodong.web.dto.receipt.ReceiptSaveRequestDto;
import solux.woodong.web.dto.receipt.ReceiptUpdateRequestDto;
import solux.woodong.web.service.receipt.ReceiptService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReceiptController {
    private final ReceiptService receiptService;

    @PostMapping("/api/udong/receipt")
    public Long save(@RequestBody ReceiptSaveRequestDto requestDto) {
        return receiptService.save(requestDto);
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
        receiptService.delete(id);
    }
}
