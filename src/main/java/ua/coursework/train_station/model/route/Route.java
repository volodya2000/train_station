package ua.coursework.train_station.model.route;

import ua.coursework.train_station.model.pausedTrip.PausedTrip;
import ua.coursework.train_station.model.ticket.Ticket;
import ua.coursework.train_station.model.train.Train;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "route")
    private List<Train> train;

    @Temporal(TemporalType.DATE)
    private Date beginOfTrip;

    @Temporal(TemporalType.DATE)
    private Date endOfTrip;

    @ManyToOne
    @JoinColumn(name = "paused_trip_id")
    private PausedTrip pausedTrip;

    private int duration;

    private String mainHalts;

    private String startStation;

    private String finalStation;

    private boolean delayed;

    private int price;

    private String direction;


    @Enumerated(EnumType.STRING)
    private RouteType routeType;

    @OneToMany(mappedBy = "route")
    private List<Ticket>tickets=new ArrayList<>();



    public Route() {
    }

    public Route(List<Ticket>tickets,PausedTrip pausedTrip, String  direction,RouteType type,int price,boolean delayed,String finalStation,String startStation,List<Train> train, Date beginOfTrip, Date endOfTrip, int duration, String mainHalts) {
        this.train = train;
        this.beginOfTrip = beginOfTrip;
        this.endOfTrip = endOfTrip;
        this.duration = duration;
        this.mainHalts = mainHalts;
        this.startStation=startStation;
        this.finalStation=finalStation;
        this.delayed=delayed;
        this.price=price;
        this.routeType=type;
        this.direction=direction;
        this.pausedTrip=pausedTrip;
        this.tickets=tickets;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Train> getTrain() {
        return train;
    }

    public void setTrain(List<Train> train) {
        this.train = train;
    }

    public Date getBeginOfTrip() {
        return beginOfTrip;
    }

    public void setBeginOfTrip(Date beginOfTrip) {
        this.beginOfTrip = beginOfTrip;
    }

    public Date getEndOfTrip() {
        return endOfTrip;
    }

    public void setEndOfTrip(Date endOfTrip) {
        this.endOfTrip = endOfTrip;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



    public String getMainHalts() {
        return mainHalts;
    }

    public void setMainHalts(String mainHalts) {
        this.mainHalts = mainHalts;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(String finalStation) {
        this.finalStation = finalStation;
    }

    public boolean isDelayed() {
        return delayed;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public PausedTrip getPausedTrip() {
        return pausedTrip;
    }

    public void setPausedTrip(PausedTrip pausedTrip) {
        this.pausedTrip = pausedTrip;
    }


    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


}
