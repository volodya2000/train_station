package ua.coursework.train_station.model.trainServiceman;

import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.train.Train;

import javax.persistence.*;

@Entity
@Table(name = "train_serviceman")
public class TrainServiceman extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne(cascade = CascadeType.ALL)
    private TrainServicemanBrigades trainServicemanBrigades;

    @OneToOne(mappedBy = "headOfDepartment")
    private TrainServicemanDepartment isHeadOfDepartment;

    public TrainServiceman(){}

    public TrainServiceman(Train train, TrainServicemanBrigades trainServicemanBrigades, TrainServicemanDepartment isHeadOfDepartment) {
        this.train = train;
        this.trainServicemanBrigades = trainServicemanBrigades;
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public TrainServiceman(String name, String surname, int age, int salary, int childrenAmount, int experience, Gender sex, Train train, TrainServicemanBrigades trainServicemanBrigades, TrainServicemanDepartment isHeadOfDepartment) {
        super(name, surname, age, salary, childrenAmount, experience, sex);
        this.train = train;
        this.trainServicemanBrigades = trainServicemanBrigades;
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TrainServicemanBrigades getTrainServicemanBrigades() {
        return trainServicemanBrigades;
    }

    public void setTrainServicemanBrigades(TrainServicemanBrigades trainServicemanBrigades) {
        this.trainServicemanBrigades = trainServicemanBrigades;
    }

    public TrainServicemanDepartment getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setIsHeadOfDepartment(TrainServicemanDepartment isHeadOfDepartment) {
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainServiceman)) return false;
        if (!super.equals(o)) return false;

        TrainServiceman that = (TrainServiceman) o;

        if (id != that.id) return false;
        if (!train.equals(that.train)) return false;
        if (!trainServicemanBrigades.equals(that.trainServicemanBrigades)) return false;
        return isHeadOfDepartment.equals(that.isHeadOfDepartment);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + train.hashCode();
        result = 31 * result + trainServicemanBrigades.hashCode();
        result = 31 * result + isHeadOfDepartment.hashCode();
        return result;
    }
}
