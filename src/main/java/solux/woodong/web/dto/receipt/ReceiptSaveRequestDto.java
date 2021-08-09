package solux.woodong.web.dto.receipt;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.receipt.Receipt;
import solux.woodong.web.domain.user.User;

@Getter
@NoArgsConstructor
public class ReceiptSaveRequestDto {
    private String cost;
    private String title;
    private String content;
    private String picture;
    private String useDate;
    private Club club;
    private User user;

    @Builder
    public ReceiptSaveRequestDto(String cost, String title, String content
            , String picture, String useDate, Club club, User user) {
        this.cost = cost;
        this.title = title;
        this.content = content;
        this.picture = picture;
        this.useDate = useDate;
        this.club = club;
        this.user = user;
    }

    public Receipt toEntity() {
        return Receipt.builder()
                .cost(cost)
                .title(title)
                .content(content)
                .picture(picture)
                .useDate(useDate)
                .club(club)
                .user(user)
                .build();
    }
}
