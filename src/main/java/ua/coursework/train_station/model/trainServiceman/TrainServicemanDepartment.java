package ua.coursework.train_station.model.trainServiceman;


import ua.coursework.train_station.model.departments.TrainDepartments;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train_serviceman_department")
public class TrainServicemanDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "department")
    private List<TrainServicemanBrigades> brigades=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "headOfDepartment_id")
    private TrainServiceman headOfDepartment;

    @OneToOne(mappedBy = "trainServiceman")
    private TrainDepartments trainDepartments;


    public TrainDepartments getTrainDepartments() {
        return trainDepartments;
    }

    public void setTrainDepartments(TrainDepartments trainDepartments) {
        this.trainDepartments = trainDepartments;
    }

    public TrainServicemanDepartment() {
    }

    public TrainServicemanDepartment(List<TrainServicemanBrigades> brigades, TrainServiceman headOfDepartment, TrainDepartments trainDepartments) {
        this.brigades = brigades;
        this.headOfDepartment = headOfDepartment;
        this.trainDepartments = trainDepartments;
    }

    public TrainServicemanDepartment(List<TrainServicemanBrigades> brigades, TrainServiceman headOfDepartment) {
        this.brigades = brigades;
        this.headOfDepartment = headOfDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TrainServicemanBrigades> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<TrainServicemanBrigades> brigades) {
        this.brigades = brigades;
    }

    public TrainServiceman getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(TrainServiceman headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}
