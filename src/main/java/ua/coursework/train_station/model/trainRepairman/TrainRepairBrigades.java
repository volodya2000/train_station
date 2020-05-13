package ua.coursework.train_station.model.trainRepairman;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "train_repair_brigades")
public class TrainRepairBrigades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "brigade")
    private List<TrainRepairman> workers;

    private String name;

    @ManyToOne
    private TrainRepairmenDepartment trainRepairmanDepartment;

    public TrainRepairBrigades() {
    }

    public TrainRepairBrigades(List<TrainRepairman> workers,
                               TrainRepairmenDepartment trainRepairmanDepartment,String name) {
        this.workers = workers;
        this.trainRepairmanDepartment = trainRepairmanDepartment;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TrainRepairman> getWorkers() {
        return workers;
    }

    public void setWorkers(List<TrainRepairman> workers) {
        this.workers = workers;
    }

    public TrainRepairmenDepartment getTrainRepairmanDepartment() {
        return trainRepairmanDepartment;
    }

    public void setTrainRepairmanDepartment(TrainRepairmenDepartment trainRepairmanDepartment) {
        this.trainRepairmanDepartment = trainRepairmanDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
