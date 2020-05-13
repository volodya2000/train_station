package ua.coursework.train_station.model.railwayRepairman;

import ua.coursework.train_station.model.Worker;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "railway_repairman_brigades")
public class RailwayRepairBrigades  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "railwayRepairBrigades")
    private List<RailwayRepairman> workers;

    private String name;

    @ManyToOne
    private RailwayRepairDepartment railwayRepairDepartment;

    public RailwayRepairBrigades() {
    }


    public RailwayRepairBrigades(List<RailwayRepairman> workers, String name, RailwayRepairDepartment railwayRepairDepartment) {
        this.workers = workers;
        this.name = name;
        this.railwayRepairDepartment = railwayRepairDepartment;
    }

    public RailwayRepairBrigades(List<RailwayRepairman> workers) {
        this.workers = workers;

    }

    public long getId() {
        return id;
    }


    public List<RailwayRepairman> getWorkers() {
        return workers;
    }

    public void setWorkers(List<RailwayRepairman> workers) {
        this.workers = workers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
