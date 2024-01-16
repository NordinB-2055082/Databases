package be.kuleuven.dbproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "GameCopy")
public class GameCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GameCopy_gen")
    @SequenceGenerator(name = "GameCopy_gen", sequenceName = "GameCopy_seq")
    @Column(name = "gameCopyId", nullable = false)
    private Long gameCopyId;

    @Column(name = "status", nullable = false)
    private Status status;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "gameId", nullable = false)
    private Game game;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "museumId", nullable = false)
    private Museum museum;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "transactionId", nullable = true)
    private Transaction transaction;

    public GameCopy() {
        this.status = Status.AVAILABLE;
    }

    public GameCopy(Game game, Museum museum, Status status) {
        this.game = game;
        this.museum = museum;
        this.status = Status.AVAILABLE;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
