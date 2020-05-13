package ua.coursework.train_station.model.dispatchers;

import ua.coursework.train_station.model.departments.TrainDepartments;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dispatcher_department")
public class DispatcherDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dispatcherDepartment")
    private List<DispatcherBrigade> dispatcherBrigades=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "headOfDepartment_id")
    private Dispatcher headOfDepartment;

    @OneToOne(mappedBy = "dispatcherDepartment")
    private TrainDepartments trainDepartments;

    public DispatcherDepartment(){}

    public DispatcherDepartment(List<DispatcherBrigade> dispatcherBrigades, Dispatcher headOfDepartment, TrainDepartments trainDepartments) {
        this.dispatcherBrigades = dispatcherBrigades;
        this.headOfDepartment = headOfDepartment;
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

    public List<DispatcherBrigade> getDispatcherBrigades() {
        return dispatcherBrigades;
    }

    public void setDispatcherBrigades(List<DispatcherBrigade> dispatcherBrigades) {
        this.dispatcherBrigades = dispatcherBrigades;
    }

    public Dispatcher getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Dispatcher headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}
