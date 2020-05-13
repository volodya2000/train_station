package ua.coursework.train_station.model.dispatchers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dispatcher_brigade")
public class DispatcherBrigade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "dispatcherBrigade")
    private List<Dispatcher> dispatchers=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "dispatcher_department_id")
    private DispatcherDepartment dispatcherDepartment;

    public DispatcherBrigade(){}

    public DispatcherBrigade(String name, List<Dispatcher> dispatchers, DispatcherDepartment dispatcherDepartment) {
        this.name = name;
        this.dispatchers = dispatchers;
        this.dispatcherDepartment = dispatcherDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dispatcher> getDispatchers() {
        return dispatchers;
    }

    public void setDispatchers(List<Dispatcher> dispatchers) {
        this.dispatchers = dispatchers;
    }

    public DispatcherDepartment getDispatcherDepartment() {
        return dispatcherDepartment;
    }

    public void setDispatcherDepartment(DispatcherDepartment dispatcherDepartment) {
        this.dispatcherDepartment = dispatcherDepartment;
    }
}
