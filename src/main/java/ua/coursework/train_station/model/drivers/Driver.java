package ua.coursework.train_station.model.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.train.Train;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int yearOfMedicalCheck;

    @ManyToOne(cascade = CascadeType.ALL)
    private DriverBrigade brigade;

    @OneToOne(mappedBy = "headOfDepartment")
    private DriverDepartment isHeadOfDepartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;
//    @Column(nullable = false)
//    private Train train;


    public Driver() {
    }

    public Driver(String name, String surname, int age, int salary, int childrenAmount, int experience,
                  Gender sex, int medicalCheck,DriverDepartment isHeadOfDepartment,
                  Train train) {
        super(name, surname, age, salary, childrenAmount, experience, sex);
        this.yearOfMedicalCheck = medicalCheck;
        this.isHeadOfDepartment=isHeadOfDepartment;
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getYearOfMedicalCheck() {
        return yearOfMedicalCheck;
    }

    public void setYearOfMedicalCheck(int yearOfMedicalCheck) {
        this.yearOfMedicalCheck = yearOfMedicalCheck;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DriverDepartment isHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setHeadOfDepartment(DriverDepartment headOfDepartment) {
        isHeadOfDepartment = headOfDepartment;
    }

    public DriverBrigade getBrigade() {
        return brigade;
    }

    public void setBrigade(DriverBrigade brigade) {
        this.brigade = brigade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        if (!super.equals(o)) return false;

        Driver driver = (Driver) o;

        if (yearOfMedicalCheck != driver.yearOfMedicalCheck) return false;
        if (!id.equals(driver.id)) return false;
        if (!brigade.equals(driver.brigade)) return false;
        return isHeadOfDepartment.equals(driver.isHeadOfDepartment);
    }

//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + id.hashCode();
//        result = 31 * result + yearOfMedicalCheck;
//        result = 31 * result + brigade.hashCode();
//        result = 31 * result + isHeadOfDepartment.hashCode();
//        return result;
//    }
}
