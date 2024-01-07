package be.kuleuven.dbproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ConsoleType")
public class ConsoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ConsoleType_gen")
    @SequenceGenerator(name = "ConsoleType_gen", sequenceName = "ConsoleType_seq")

    @Column(name = "consoleTypeId", nullable = false)
    private Long consoleTypeId;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "adressForRepairing", nullable = false)
    private String addressForRepairing;
    @Column(name = "releaseDate", nullable = false)
    private LocalDate releaseDate;

   @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Game_ConsoleType",
            joinColumns = { @JoinColumn(name = "consoleTypeId") },
            inverseJoinColumns = { @JoinColumn(name = "gameId") }
    )
    private List<Game> gamesOfConsoleType;


    public ConsoleType() {
        gamesOfConsoleType = new ArrayList<>();
    }

    public ConsoleType(String name, String manufacturer, String addressForRepairing, LocalDate releaseDate) {
        gamesOfConsoleType = new ArrayList<>();
        this.name = name;
        this.manufacturer = manufacturer;
        this.addressForRepairing = addressForRepairing;
        this.releaseDate = releaseDate;
    }

    public void addGame(Game game) {
        gamesOfConsoleType.add(game);
        game.getConsoleTypesOfGame().add(this);
    }

    public Long getConsoleTypeId() {
        return consoleTypeId;
    }

    public void setConsoleTypeId(Long consoleTypeId) {
        this.consoleTypeId = consoleTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getAddressForRepairing() {
        return addressForRepairing;
    }

    public void setAddressForRepairing(String addressForRepairing) {
        this.addressForRepairing = addressForRepairing;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Game> getGamesOfConsoleType() {
        return gamesOfConsoleType;
    }

    public void setGamesOfConsoleType(List<Game> gamesOfConsoleType) {
        this.gamesOfConsoleType = gamesOfConsoleType;
    }
}
