package ua.coursework.train_station.model.drivers;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver_brigades")
public class DriverBrigade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "brigade")
    private List<Driver> driversInBrigade;

    @ManyToOne
    private DriverDepartment driverDepartment;

    private String name;

    public DriverBrigade() {
    }

    public DriverBrigade(List<Driver> driversInBrigade, String name,DriverDepartment driverDepartment) {
        this.driversInBrigade = driversInBrigade;
        this.name = name;
        this.driverDepartment=driverDepartment;
    }

    public List<Driver> getDriversInBrigade() {
        return driversInBrigade;
    }

    public void setDriversInBrigade(List<Driver> driversInBrigade) {
        this.driversInBrigade = driversInBrigade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public DriverDepartment getDriverDepartment() {
        return driverDepartment;
    }

    public void setDriverDepartment(DriverDepartment driverDepartment) {
        this.driverDepartment = driverDepartment;
    }
}
