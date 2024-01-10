package be.kuleuven.dbproject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Game_gen")
    @SequenceGenerator(name = "Game_gen", sequenceName = "Game_seq")
    @Column(name = "gameId", nullable = false)
    private Long gameId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "developer", nullable = false)
    private String developer;

    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "ageClassification", nullable = false)
    private int ageClassification;

    @Column(name = "releaseDate", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "price", nullable = false)
    private float price;


   /*
    @ManyToMany(mappedBy = "gamesOfConsoleType") //https://www.baeldung.com/hibernate-many-to-many
    private List<ConsoleType> consoleTypesOfGame;
*/
   @ManyToMany(cascade = CascadeType.ALL)
   private List<ConsoleType> consoleTypesOfGame;

   @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
   private List<GameCopy> gameCopies;

   // Constructors, getters, setters
   public Game() {
       consoleTypesOfGame = new ArrayList<>();
       gameCopies = new ArrayList<>();
   }
    public Game(Long gameId, String title, String developer, String genre, String description, int ageClassification, LocalDate releaseDate, float price) {
        consoleTypesOfGame = new ArrayList<>();
        gameCopies = new ArrayList<>();
        this.gameId = gameId;
        this.title = title;
        this.developer = developer;
        this.genre = genre;
        this.description = description;
        this.ageClassification = ageClassification;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public List<ConsoleType> getConsoleTypesOfGame() {
        return consoleTypesOfGame;
    }

    public void setConsoleTypesOfGame(List<ConsoleType> consoleTypesOfGame) {
        this.consoleTypesOfGame = consoleTypesOfGame;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeClassification() {
        return ageClassification;
    }

    public void setAgeClassification(int ageClassification) {
        this.ageClassification = ageClassification;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
