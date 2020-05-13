package ua.coursework.train_station.model.helpDeskService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "helpDesk_service_brigades")
public class HelpDeskServiceBrigades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "brigades")
    private List<HelpDeskServiceMan> helpDeskServiceManList=new ArrayList<>();

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private HelpDeskServiceDepartment department;

    private HelpDeskServiceBrigades(){}

    public HelpDeskServiceBrigades(List<HelpDeskServiceMan> helpDeskServiceManList, String name, HelpDeskServiceDepartment department) {
        this.helpDeskServiceManList = helpDeskServiceManList;
        this.name = name;
        this.department = department;
    }

    public List<HelpDeskServiceMan> getHelpDeskServiceManList() {
        return helpDeskServiceManList;
    }

    public void setHelpDeskServiceManList(List<HelpDeskServiceMan> helpDeskServiceManList) {
        this.helpDeskServiceManList = helpDeskServiceManList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelpDeskServiceDepartment getDepartment() {
        return department;
    }

    public void setDepartment(HelpDeskServiceDepartment department) {
        this.department = department;
    }
}
