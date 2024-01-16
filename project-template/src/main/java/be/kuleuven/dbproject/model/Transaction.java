package be.kuleuven.dbproject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Transaction_gen")
    @SequenceGenerator(name = "Transaction_gen", sequenceName = "Transaction_seq")
    @Column(name = "transactionId", nullable = false)
    private Long transactionId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;


    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<GameCopy> gameCopiesInTransaction;

    public Transaction() {
        gameCopiesInTransaction = new ArrayList<>();
    }

    public Transaction(LocalDate date) {
        gameCopiesInTransaction = new ArrayList<>();
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<GameCopy> getGameCopiesInTransaction() {
        return gameCopiesInTransaction;
    }

    public void setGameCopiesInTransaction(List<GameCopy> gameCopiesInTransaction) {
        this.gameCopiesInTransaction = gameCopiesInTransaction;
    }
}