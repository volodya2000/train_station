package ua.coursework.train_station.model.cashiers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cashier_brigades")
public class CashierBrigades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private CashierDepartment department;

    @OneToMany(mappedBy = "brigade")
    private List<Cashier> cashiers=new ArrayList<>();

    public CashierBrigades() {
    }

    public CashierBrigades(String name, CashierDepartment department, List<Cashier> cashiers) {
        this.name = name;
        this.department = department;
        this.cashiers = cashiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CashierDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CashierDepartment department) {
        this.department = department;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public void setCashiers(List<Cashier> cashiers) {
        this.cashiers = cashiers;
    }
}
