package ua.coursework.train_station.model.railwayRepairman;

import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.train.Train;

import javax.persistence.*;

@Entity
@Table(name = "railway_repairman")
public class RailwayRepairman extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;

    @Enumerated(value = EnumType.STRING)
    private RepairmanEducation education;

    @ManyToOne(cascade = CascadeType.ALL)
    private RailwayRepairBrigades railwayRepairBrigades;

    public RailwayRepairman(RepairmanEducation education, RailwayRepairBrigades railwayRepairBrigades, RailwayRepairDepartment isHeadOfDepartment) {
        this.education = education;
        this.railwayRepairBrigades = railwayRepairBrigades;
        this.isHeadOfRailwayRepairmanDepartment = isHeadOfDepartment;
    }

    @OneToOne(mappedBy = "headOfDepartment")
    private RailwayRepairDepartment isHeadOfRailwayRepairmanDepartment;

    public RailwayRepairman() {
    }

    public RailwayRepairman(Train train,RepairmanEducation education, RailwayRepairBrigades railwayRepairBrigades) {
        this.education = education;
        this.train=train;
        this.railwayRepairBrigades = railwayRepairBrigades;
    }

    public long getId() {
        return id;
    }

    public RepairmanEducation getEducation() {
        return education;
    }

    public void setEducation(RepairmanEducation education) {
        this.education = education;
    }

    public RailwayRepairBrigades getRailwayRepairBrigades() {
        return railwayRepairBrigades;
    }

    public void setRailwayRepairBrigades(RailwayRepairBrigades railwayRepairBrigades) {
        this.railwayRepairBrigades = railwayRepairBrigades;
    }

    public RailwayRepairDepartment getIsHeadOfDepartment() {
        return isHeadOfRailwayRepairmanDepartment;
    }

    public void setIsHeadOfDepartment(RailwayRepairDepartment isHeadOfDepartment) {
        this.isHeadOfRailwayRepairmanDepartment = isHeadOfDepartment;
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
        if (!(o instanceof RailwayRepairman)) return false;
        if (!super.equals(o)) return false;

        RailwayRepairman that = (RailwayRepairman) o;

        if (id != that.id) return false;
        if (education != that.education) return false;
        if (!railwayRepairBrigades.equals(that.railwayRepairBrigades)) return false;
        return isHeadOfRailwayRepairmanDepartment.equals(that.isHeadOfRailwayRepairmanDepartment);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + education.hashCode();
        result = 31 * result + railwayRepairBrigades.hashCode();
        result=31*result+train.hashCode();
        result = 31 * result + isHeadOfRailwayRepairmanDepartment.hashCode();
        return result;
    }
}
