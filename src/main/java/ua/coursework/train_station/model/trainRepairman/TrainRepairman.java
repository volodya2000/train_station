package ua.coursework.train_station.model.trainRepairman;


import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.drivers.DriverDepartment;
import ua.coursework.train_station.model.train.Train;

import javax.persistence.*;

@Entity
@Table(name = "train_repairman")
public class TrainRepairman  extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private boolean hasDiploma;

    @ManyToOne(cascade = CascadeType.ALL)
    private TrainRepairBrigades brigade;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;

    @OneToOne(mappedBy = "headOfDepartment")
    private TrainRepairmenDepartment isHeadOfDepartment;


    public TrainRepairman() {
    }

    public TrainRepairman(Train train,boolean hasDiploma, TrainRepairBrigades brigade, TrainRepairmenDepartment isHeadOfDepartment) {
        this.hasDiploma = hasDiploma;
        this.brigade = brigade;
        this.train=train;
        this.isHeadOfDepartment=isHeadOfDepartment;
    }

    public long getId() {
        return id;
    }

    public boolean isHasDiploma() {
        return hasDiploma;
    }

    public void setHasDiploma(boolean hasDiploma) {
        this.hasDiploma = hasDiploma;
    }

    public TrainRepairBrigades getBrigade() {
        return brigade;
    }

    public void setBrigade(TrainRepairBrigades brigade) {
        this.brigade = brigade;
    }

    public TrainRepairmenDepartment getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setIsHeadOfDepartment(TrainRepairmenDepartment isHeadOfDepartment) {
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainRepairman)) return false;
        if (!super.equals(o)) return false;

        TrainRepairman that = (TrainRepairman) o;

        if (id != that.id) return false;
        if (hasDiploma != that.hasDiploma) return false;
        if (!brigade.equals(that.brigade)) return false;
        return isHeadOfDepartment.equals(that.isHeadOfDepartment);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (hasDiploma ? 1 : 0);
        result = 31 * result + brigade.hashCode();
        result = 31 * result + isHeadOfDepartment.hashCode();
        return result;
    }
}
