package ua.coursework.train_station.model.cashiers;

import ua.coursework.train_station.model.departments.TrainDepartments;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cashier_department")
public class CashierDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "department")
    private List<CashierBrigades> brigades=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "headOfDepartment_id")
    private Cashier headOfDepartment;

    @OneToOne(mappedBy = "cashierDepartment")
    private TrainDepartments trainDepartments;

    public CashierDepartment() {
    }

    public CashierDepartment(List<CashierBrigades> brigades, Cashier headOfDepartment, TrainDepartments trainDepartments) {
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

    public List<CashierBrigades> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<CashierBrigades> brigades) {
        this.brigades = brigades;
    }

    public Cashier getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Cashier headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}
