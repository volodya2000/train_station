package ua.coursework.train_station.model.helpDeskService;

import ua.coursework.train_station.model.departments.TrainDepartments;
import ua.coursework.train_station.model.trainServiceman.TrainServiceman;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "helpDesk_service_department")
public class HelpDeskServiceDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "department")
    private List<HelpDeskServiceBrigades> brigades=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "headOfDepartment_id")
    private HelpDeskServiceMan headOfDepartment;

    @OneToOne(mappedBy = "helpDeskServiceDepartment")
    private TrainDepartments trainDepartments;

    public HelpDeskServiceDepartment(){}

    public HelpDeskServiceDepartment(List<HelpDeskServiceBrigades> brigades, HelpDeskServiceMan headOfDepartment, TrainDepartments trainDepartments) {
        this.brigades = brigades;
        this.headOfDepartment = headOfDepartment;
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

    public List<HelpDeskServiceBrigades> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<HelpDeskServiceBrigades> brigades) {
        this.brigades = brigades;
    }

    public HelpDeskServiceMan getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(HelpDeskServiceMan headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}
