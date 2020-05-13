package ua.coursework.train_station.model.trainServiceman;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train_serviceman_brigades")
public class TrainServicemanBrigades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "trainServicemanBrigades")
    private List<TrainServiceman>trainServicemen=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    private TrainServicemanDepartment department;

    private TrainServicemanBrigades(){}

    public TrainServicemanBrigades(String name, List<TrainServiceman> trainServicemen, TrainServicemanDepartment department) {
        this.name = name;
        this.trainServicemen = trainServicemen;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrainServiceman> getTrainServicemen() {
        return trainServicemen;
    }

    public void setTrainServicemen(List<TrainServiceman> trainServicemen) {
        this.trainServicemen = trainServicemen;
    }

    public TrainServicemanDepartment getDepartment() {
        return department;
    }

    public void setDepartment(TrainServicemanDepartment department) {
        this.department = department;
    }
}
