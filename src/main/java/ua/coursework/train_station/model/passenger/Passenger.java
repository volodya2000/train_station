package ua.coursework.train_station.model.passenger;

import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.ticket.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    private boolean clothesInLuggage ;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets=new ArrayList<>();

    public Passenger() {
    }

    public Passenger(String name, Gender gender, int age, boolean clothesInLuggage, List<Ticket> tickets) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.clothesInLuggage = clothesInLuggage;
        this.tickets = tickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isClothesInLuggage() {
        return clothesInLuggage;
    }

    public void setClothesInLuggage(boolean clothesInLuggage) {
        this.clothesInLuggage = clothesInLuggage;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
