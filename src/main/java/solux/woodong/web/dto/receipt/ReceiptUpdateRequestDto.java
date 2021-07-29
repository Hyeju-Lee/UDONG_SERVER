package solux.woodong.web.dto.receipt;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReceiptUpdateRequestDto {
    private String title;
    private String content;
    private String cost;
    private String picture;
    private String useDate;

    @Builder
    public ReceiptUpdateRequestDto(String cost, String title, String content, String picture, String useDate) {
        this.title = title;
        this.content = content;
        this.cost = cost;
        this.picture = picture;
        this.useDate = useDate;
    }
}
