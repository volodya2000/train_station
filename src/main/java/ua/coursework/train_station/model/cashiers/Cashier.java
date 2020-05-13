package ua.coursework.train_station.model.cashiers;


import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;

import javax.persistence.*;

@Entity
@Table(name = "cashier")
public class Cashier extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cashDeskNumber;

    @ManyToOne
    @JoinColumn(name = "brigade_id")
    private CashierBrigades brigade;

    @OneToOne(mappedBy = "headOfDepartment")
    private CashierDepartment isHeadOfDepartment;

    public Cashier(){}

    public Cashier(int cashDeskNumber, CashierBrigades brigade, CashierDepartment isHeadOfDepartment) {
        this.cashDeskNumber = cashDeskNumber;
        this.brigade = brigade;
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public Cashier(String name, String surname, int age, int salary, int childrenAmount, int experience, Gender sex, int cashDeskNumber, CashierBrigades brigade, CashierDepartment isHeadOfDepartment) {
        super(name, surname, age, salary, childrenAmount, experience, sex);
        this.cashDeskNumber = cashDeskNumber;
        this.brigade = brigade;
        this.isHeadOfDepartment = isHeadOfDepartment;
    }


    public void setId(long id) {
        this.id = id;
    }

    public int getCashDeskNumber() {
        return cashDeskNumber;
    }

    public void setCashDeskNumber(int cashDeskNumber) {
        this.cashDeskNumber = cashDeskNumber;
    }

    public CashierBrigades getBrigade() {
        return brigade;
    }

    public void setBrigade(CashierBrigades brigade) {
        this.brigade = brigade;
    }

    public CashierDepartment getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setIsHeadOfDepartment(CashierDepartment isHeadOfDepartment) {
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cashier)) return false;
        if (!super.equals(o)) return false;

        Cashier cashier = (Cashier) o;

        if (id != cashier.id) return false;
        if (cashDeskNumber != cashier.cashDeskNumber) return false;
        if (!brigade.equals(cashier.brigade)) return false;
        return isHeadOfDepartment.equals(cashier.isHeadOfDepartment);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + cashDeskNumber;
        result = 31 * result + brigade.hashCode();
        result = 31 * result + isHeadOfDepartment.hashCode();
        return result;
    }
}
