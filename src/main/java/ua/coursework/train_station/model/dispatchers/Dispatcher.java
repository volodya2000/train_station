package ua.coursework.train_station.model.dispatchers;

import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;

import javax.persistence.*;

@Entity
@Table(name = "dispatchers")
public class Dispatcher extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cashDeskNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brigade_id")
    private DispatcherBrigade dispatcherBrigade;

    @OneToOne(mappedBy = "headOfDepartment")
    private DispatcherDepartment isHeadOfDepartment;

    public Dispatcher(){}

    public Dispatcher(String name, String surname, int age, int salary, int childrenAmount, int experience, Gender sex,
                      int cashDeskNumber,DispatcherBrigade dispatcherBrigade,DispatcherDepartment isHeadOfDepartment) {
        super(name, surname, age, salary, childrenAmount, experience, sex);
        this.cashDeskNumber = cashDeskNumber;
        this.dispatcherBrigade=dispatcherBrigade;
        this.isHeadOfDepartment=isHeadOfDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCashDeskNumber() {
        return cashDeskNumber;
    }

    public void setCashDeskNumber(int cashDeskNumber) {
        this.cashDeskNumber = cashDeskNumber;
    }

    public DispatcherBrigade getDispatcherBrigade() {
        return dispatcherBrigade;
    }

    public void setDispatcherBrigade(DispatcherBrigade dispatcherBrigade) {
        this.dispatcherBrigade = dispatcherBrigade;
    }

    public DispatcherDepartment getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setIsHeadOfDepartment(DispatcherDepartment isHeadOfDepartment) {
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispatcher)) return false;
        if (!super.equals(o)) return false;

        Dispatcher that = (Dispatcher) o;

        if (cashDeskNumber != that.cashDeskNumber) return false;
        if (!id.equals(that.id)) return false;
        if (!dispatcherBrigade.equals(that.dispatcherBrigade)) return false;
        return isHeadOfDepartment.equals(that.isHeadOfDepartment);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + cashDeskNumber;
        result = 31 * result + dispatcherBrigade.hashCode();
        result = 31 * result + isHeadOfDepartment.hashCode();
        return result;
    }
}
