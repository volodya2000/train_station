package ua.coursework.train_station.model.trainRepairman;

import ua.coursework.train_station.model.departments.TrainDepartments;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train_repairman_department")
public class TrainRepairmenDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "headOfDepartment_id")
    private TrainRepairman headOfDepartment;

    @OneToMany(mappedBy = "trainRepairmanDepartment")
    private List<TrainRepairBrigades> brigades=new ArrayList<>();


    @OneToOne(mappedBy = "trainRepairmenDepartment")
    private TrainDepartments trainDepartments;

    public TrainRepairmenDepartment() {
    }

    public TrainRepairmenDepartment(TrainRepairman headOfDepartment, List<TrainRepairBrigades> brigades, TrainDepartments trainDepartments) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainRepairman getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(TrainRepairman headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public List<TrainRepairBrigades> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<TrainRepairBrigades> brigades) {
        this.brigades = brigades;
    }
}
