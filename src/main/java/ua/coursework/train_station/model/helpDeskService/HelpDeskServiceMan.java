package ua.coursework.train_station.model.helpDeskService;

import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;

import javax.persistence.*;

@Entity
@Table(name = "helpDeskServiceMan")
public class HelpDeskServiceMan extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private HelpService helpService;

    @ManyToOne
    @JoinColumn(name = "brigade_id")
    private HelpDeskServiceBrigades brigades;

    @OneToOne(mappedBy = "headOfDepartment")
    private HelpDeskServiceDepartment isHeadOfDepartment;

    private HelpDeskServiceMan(){}

    public HelpDeskServiceMan(HelpService helpService, HelpDeskServiceBrigades brigades, HelpDeskServiceDepartment isHeadOfDepartment) {
        this.helpService = helpService;
        this.brigades = brigades;
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public HelpDeskServiceMan(String name, String surname, int age, int salary, int childrenAmount, int experience, Gender sex, HelpService helpService, HelpDeskServiceBrigades brigades, HelpDeskServiceDepartment isHeadOfDepartment) {
        super(name, surname, age, salary, childrenAmount, experience, sex);
        this.helpService = helpService;
        this.brigades = brigades;
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HelpService getHelpService() {
        return helpService;
    }

    public void setHelpService(HelpService helpService) {
        this.helpService = helpService;
    }

    public HelpDeskServiceBrigades getBrigades() {
        return brigades;
    }

    public void setBrigades(HelpDeskServiceBrigades brigades) {
        this.brigades = brigades;
    }

    public HelpDeskServiceDepartment getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public void setIsHeadOfDepartment(HelpDeskServiceDepartment isHeadOfDepartment) {
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HelpDeskServiceMan)) return false;
        if (!super.equals(o)) return false;

        HelpDeskServiceMan that = (HelpDeskServiceMan) o;

        if (id != that.id) return false;
        if (helpService != that.helpService) return false;
        if (!brigades.equals(that.brigades)) return false;
        return isHeadOfDepartment.equals(that.isHeadOfDepartment);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + helpService.hashCode();
        result = 31 * result + brigades.hashCode();
        result = 31 * result + isHeadOfDepartment.hashCode();
        return result;
    }
}
