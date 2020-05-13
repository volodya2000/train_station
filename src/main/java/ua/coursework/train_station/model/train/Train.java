package ua.coursework.train_station.model.train;

import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.route.Route;
import ua.coursework.train_station.model.trainRepairman.TrainRepairman;
import ua.coursework.train_station.model.trainServiceman.TrainServiceman;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    private int tripsBeforeInspection;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Temporal(TemporalType.DATE)
    private Date dateOfInspection;

    private int numberOfTrips;

    private int numberOfInspections;

    @Enumerated(EnumType.STRING)
    private TrainType type;

    @OneToMany(mappedBy = "train")
    private List<Driver>drivers=new ArrayList<>();

    @OneToMany(mappedBy = "train")
    private List<TrainRepairman> trainRepairmen=new ArrayList<>();

    @OneToMany(mappedBy = "train")
    private List<TrainServiceman>trainServicemen=new ArrayList<>();

    public Train() {
    }

    public Train(int tripsBeforeInspection,int age,String name, Route route, Date dateOfInspection, int numberOfTrips, int numberOfInspections, TrainType type, List<Driver> drivers, List<TrainRepairman> trainRepairmen, List<TrainServiceman> trainServicemen) {
        this.name = name;
        this.route = route;
        this.dateOfInspection = dateOfInspection;
        this.numberOfTrips = numberOfTrips;
        this.numberOfInspections = numberOfInspections;
        this.type = type;
        this.drivers = drivers;
        this.trainRepairmen = trainRepairmen;
        this.trainServicemen = trainServicemen;
        this.age=age;
        this.tripsBeforeInspection=tripsBeforeInspection;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDateOfInspection() {
        return dateOfInspection;
    }

    public void setDateOfInspection(Date dateOfInspection) {
        this.dateOfInspection = dateOfInspection;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    public int getNumberOfInspections() {
        return numberOfInspections;
    }

    public void setNumberOfInspections(int numberOfInspections) {
        this.numberOfInspections = numberOfInspections;
    }

    public TrainType getType() {
        return type;
    }

    public void setType(TrainType type) {
        this.type = type;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<TrainRepairman> getTrainRepairmen() {
        return trainRepairmen;
    }

    public void setTrainRepairmen(List<TrainRepairman> trainRepairmen) {
        this.trainRepairmen = trainRepairmen;
    }

    public List<TrainServiceman> getTrainServicemen() {
        return trainServicemen;
    }

    public void setTrainServicemen(List<TrainServiceman> trainServicemen) {
        this.trainServicemen = trainServicemen;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTripsBeforeInspection() {
        return tripsBeforeInspection;
    }

    public void setTripsBeforeInspection(int tripsBeforeInspection) {
        this.tripsBeforeInspection = tripsBeforeInspection;
    }

}
