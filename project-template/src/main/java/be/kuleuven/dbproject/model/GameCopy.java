package be.kuleuven.dbproject.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "GameCopy")
public class GameCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GameCopy_gen")
    @SequenceGenerator(name = "GameCopy_gen", sequenceName = "GameCopy_seq")
    @Column(name = "gameCopyId", nullable = false)
    private Long gameCopyId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "gameId", nullable = false)
    private Game game;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "museumId", nullable = false)
    private Museum museum;

    public GameCopy() {

    }

    public GameCopy(Game game, Museum museum) {
        this.game = game;
        this.museum = museum;
    }

    public Long getGameCopyId() {
        return gameCopyId;
    }

    public void setGameCopyId(Long gameCopyId) {
        this.gameCopyId = gameCopyId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }
}
