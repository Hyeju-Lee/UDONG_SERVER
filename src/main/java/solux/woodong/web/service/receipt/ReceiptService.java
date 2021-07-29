package solux.woodong.web.service.receipt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.receipt.Receipt;
import solux.woodong.web.domain.receipt.ReceiptRepository;
import solux.woodong.web.dto.receipt.ReceiptResponseDto;
import solux.woodong.web.dto.receipt.ReceiptSaveRequestDto;
import solux.woodong.web.dto.receipt.ReceiptUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReceiptService {
    private final ReceiptRepository receiptRepository;

    @Transactional
    public Long save(ReceiptSaveRequestDto requestDto) {
        return receiptRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ReceiptUpdateRequestDto requestDto) {
        Receipt receipt = receiptRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("receipt 없음+id"+id));
        receipt.update(requestDto.getCost(), requestDto.getTitle(),requestDto.getContent(),
                requestDto.getPicture(),requestDto.getUseDate());
        return id;
    }

    public ReceiptResponseDto findById (Long id) {
        Receipt entity = receiptRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 기록 없음"));
        return new ReceiptResponseDto(entity);
    }

    public List<Receipt> findAll() {return receiptRepository.findAll();}

    public void delete(Long id) {receiptRepository.deleteById(id);}
}
