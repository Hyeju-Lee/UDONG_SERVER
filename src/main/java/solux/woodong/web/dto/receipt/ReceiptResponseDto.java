package solux.woodong.web.dto.receipt;

import lombok.Getter;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.receipt.Receipt;

import java.time.LocalDateTime;

@Getter
public class ReceiptResponseDto {
    private Long id;
    private String cost;
    private String title;
    private String content;
    private String picture;
    private String useDate;
    private Club club;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ReceiptResponseDto(Receipt entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.cost = entity.getCost();
        this.picture = entity.getPicture();
        this.useDate = entity.getUseDate();
        this.club = entity.getClub();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
