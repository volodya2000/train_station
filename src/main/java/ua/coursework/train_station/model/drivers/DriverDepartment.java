package ua.coursework.train_station.model.drivers;

import ua.coursework.train_station.model.departments.TrainDepartments;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "driver_department")
public class DriverDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="headOfDepartment_id")
    private Driver headOfDepartment;

    @OneToMany(mappedBy = "driverDepartment")
    private List<DriverBrigade> allBrigades=new ArrayList<>();

    @OneToOne(mappedBy = "driverDepartment")
    private TrainDepartments trainDepartments;

    public void setHeadOfDepartment(Driver headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public void setAllBrigades(List<DriverBrigade> allBrigades) {
        this.allBrigades = allBrigades;
    }

    public Driver getHeadOfDepartment() {
        return headOfDepartment;
    }

    public List<DriverBrigade> getAllBrigades() {
        return allBrigades;
    }

    public DriverDepartment() {
    }

    public DriverDepartment(Driver headOfDepartment, List<DriverBrigade> allBrigades, TrainDepartments trainDepartments) {
        this.headOfDepartment = headOfDepartment;
        this.allBrigades = allBrigades;
        this.trainDepartments = trainDepartments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainDepartments getTrainDepartments() {
        return trainDepartments;
    }

    public void setTrainDepartments(TrainDepartments trainDepartments) {
        this.trainDepartments = trainDepartments;
    }
}
