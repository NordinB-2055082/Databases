package be.kuleuven.dbproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//waarom .SEQUENCE: https://thorben-janssen.com/jpa-generate-primary-keys/
// https://www.youtube.com/watch?v=n_tc6Nc4tfI
// .IDENTITY niet efficient
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_gen")
    @SequenceGenerator(name = "Employee_gen", sequenceName = "Employee_seq")
    @Column(name = "employeeId", nullable = false)
    private Long employeeId;
   // @Column(name = "museumId", nullable = false)
    //private Long museumId = 1L;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastname;



    @ManyToOne
    @JoinColumn(name="museumId", nullable=false)
    private Museum museum;



    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }



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

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {this.museum = museum;}


    // ToString

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
               // ", museumId='" + museumId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}