package ua.coursework.train_station.model.railwayRepairman;

import ua.coursework.train_station.model.departments.TrainDepartments;
import ua.coursework.train_station.model.drivers.Driver;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "railway_repairman_department")
public class RailwayRepairDepartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="headOfDepartment_id")
    private RailwayRepairman headOfDepartment;

    @OneToMany(mappedBy = "railwayRepairDepartment")
    private List<RailwayRepairBrigades> brigades;

    @OneToOne(mappedBy = "railwayRepairDepartment")
    private TrainDepartments trainDepartments;

    public RailwayRepairDepartment() {
    }

    public RailwayRepairDepartment(RailwayRepairman headOfDepartment, List<RailwayRepairBrigades> brigades, TrainDepartments trainDepartments) {
        this.headOfDepartment = headOfDepartment;
        this.brigades = brigades;
        this.trainDepartments = trainDepartments;
    }


    public TrainDepartments getTrainDepartments() {
        return trainDepartments;
    }

    public void setTrainDepartments(TrainDepartments trainDepartments) {
        this.trainDepartments = trainDepartments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RailwayRepairman getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(RailwayRepairman headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public List<RailwayRepairBrigades> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<RailwayRepairBrigades> brigades) {
        this.brigades = brigades;
    }
}
