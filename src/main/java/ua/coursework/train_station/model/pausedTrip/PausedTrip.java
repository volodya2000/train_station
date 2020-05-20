package ua.coursework.train_station.model.pausedTrip;

import ua.coursework.train_station.model.route.Route;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paused_trip")
public class PausedTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cause;

    @Temporal(TemporalType.DATE)
    private Date begin;

    @Temporal(TemporalType.DATE)
    private Date end;

    @OneToMany(mappedBy = "pausedTrip")
    private List<Route> route;

    private int numberOfCanceledTickets;

    public PausedTrip() {
    }

    public PausedTrip(List<Route> route, String cause, Date begin, Date end, int numberOfCanceledTickets) {
        this.cause = cause;
        this.begin = begin;
        this.end = end;
        this.route=route;
        this.numberOfCanceledTickets = numberOfCanceledTickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getNumberOfCanceledTickets() {
        return numberOfCanceledTickets;
    }

    public void setNumberOfCanceledTickets(int numberOfCanceledTickets) {
        this.numberOfCanceledTickets = numberOfCanceledTickets;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }
}
