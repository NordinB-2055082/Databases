package be.kuleuven.dbproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client implements User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Client_gen")
    @SequenceGenerator(name = "Client_gen", sequenceName = "Client_seq")
    @Column(name = "clientId", nullable = false)
    private Long clientId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    /*
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Transaction> transactionsOfClient;
    */
    public Client(String email, String password, LocalDate birthdate, String gender, String name, String lastname) {
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
        this.name = name;
        this.lastname = lastname;
        //transactionsOfClient = new ArrayList<>();
    }

    public Client() {
        //transactionsOfClient = new ArrayList<>();
    }
    /*
    public List<Transaction> getTransactionsOfClient() {
        return transactionsOfClient;
    }

    public void setTransactionsOfClient(List<Transaction> transactionsOfClient) {
        this.transactionsOfClient = transactionsOfClient;
    }
    */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
