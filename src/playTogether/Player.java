package playTogether;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickName;
    private LocalDateTime birthday;
    private Position position;


    public Player() {
    }

    public Player(String nickName, LocalDateTime birthday, Position position) {
        this.nickName = nickName;
        this.birthday = birthday;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String firstName) {
        this.nickName = firstName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
