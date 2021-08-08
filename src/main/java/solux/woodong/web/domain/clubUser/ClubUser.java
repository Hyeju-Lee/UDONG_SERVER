package solux.woodong.web.domain.clubUser;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solux.woodong.web.domain.club.Club;
import solux.woodong.web.domain.user.User;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ClubUser {

    @Id
    @Column(name = "ClubUser_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Club_Id")
    private Club club;

    private int teamNumber;

    @Builder
    public ClubUser(User user, Club club, int teamNumber) {
        this.user = user;
        this.club = club;
        this.teamNumber = teamNumber;
    }

    public void update(int teamNumber) {
        this.teamNumber = teamNumber;
    }

}
