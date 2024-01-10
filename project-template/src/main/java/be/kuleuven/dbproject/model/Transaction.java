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


}