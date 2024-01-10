package be.kuleuven.dbproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Museum")
public class Museum {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Museum_GEN")
    @SequenceGenerator(name = "Museum_GEN", sequenceName = "Museum_SEQ")
    @Column(name = "museumId", nullable = false)
    private Long museumId;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "visitorsPerYear", nullable = false)
    private int visitorsPerYear;

    @Column(name = "entranceFee", nullable = false)
    private float entranceFee;


    @Column(name = "donations", nullable = false)
    private float donations;


    @OneToMany(mappedBy="museum")
    private List<Employee> employeesOfMuseum;

    @OneToMany(mappedBy = "museum")
    private List<GameCopy> gameCopiesOfMuseum;


    // Constructors, getters, setters, and ToString
    public Museum(String name, String location, int visitorsPerYear, float entranceFee, float donations) {
        gameCopiesOfMuseum = new ArrayList<>();
        employeesOfMuseum = new ArrayList<>();
        this.name = name;
        this.location = location;
        this.visitorsPerYear = visitorsPerYear;
        this.entranceFee = entranceFee;
        this.donations = donations;
    }

    public Museum() {
        gameCopiesOfMuseum = new ArrayList<>();
        employeesOfMuseum = new ArrayList<>();
    }

    public List<Employee> getEmployeesOfMuseum() {
        return employeesOfMuseum;
    }

    public List<GameCopy> getGameCopiesOfMuseum() {
        return gameCopiesOfMuseum;
    }

    public void setGameCopiesOfMuseum(List<GameCopy> gameCopiesOfMuseum) {
        this.gameCopiesOfMuseum = gameCopiesOfMuseum;
    }

    public Long getMuseumId() {
        return museumId;
    }

    public void setMuseumId(Long museumId) {
        this.museumId = museumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVisitorsPerYear() {
        return visitorsPerYear;
    }

    public void setVisitorsPerYear(int visitorsPerYear) {
        this.visitorsPerYear = visitorsPerYear;
    }

    public float getEntranceFee() {
        return entranceFee;
    }

    public void setEntranceFee(float entranceFee) {
        this.entranceFee = entranceFee;
    }

    public float getDonations() {
        return donations;
    }

    public void setDonations(float donations) {
        this.donations = donations;
    }
    @Override
    public String toString() {
        return "Museum{" +
                "museumId=" + museumId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", visitorsPerYear=" + visitorsPerYear +
                ", entranceFee=" + entranceFee +
                ", donations=" + donations +
                '}';
    }
}