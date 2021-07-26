package solux.woodong.web.domain.club;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int generation;

    @Column(columnDefinition = "LONGTEXT")
    private String info;

    @Builder
    public Club(String name, int generation, String info) {
        this.name = name;
        this.generation = generation;
        this.info = info;
    }
}
