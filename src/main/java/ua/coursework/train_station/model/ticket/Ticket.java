package ua.coursework.train_station.model.ticket;

import ua.coursework.train_station.model.passenger.Passenger;
import ua.coursework.train_station.model.route.Route;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean cancelled;

    private boolean isBought;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(boolean isBought,boolean cancelled, Route route, Passenger passenger) {
        this.cancelled = cancelled;
        this.route = route;
        this.passenger = passenger;
        this.isBought=isBought;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }
}
