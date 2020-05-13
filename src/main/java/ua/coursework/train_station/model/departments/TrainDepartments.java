package ua.coursework.train_station.model.departments;

import org.hibernate.jdbc.Work;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierDepartment;
import ua.coursework.train_station.model.dispatchers.DispatcherDepartment;
import ua.coursework.train_station.model.drivers.DriverDepartment;
import ua.coursework.train_station.model.helpDeskService.HelpDeskServiceDepartment;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairDepartment;
import ua.coursework.train_station.model.trainRepairman.TrainRepairmenDepartment;
import ua.coursework.train_station.model.trainServiceman.TrainServiceman;
import ua.coursework.train_station.model.trainServiceman.TrainServicemanDepartment;

import javax.persistence.*;

@Entity
@Table(name = "train_departments")
public class TrainDepartments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "cashier_department_id")
    private CashierDepartment cashierDepartment;

    @OneToOne
    @JoinColumn(name = "dispatcher_department_id")
    private DispatcherDepartment dispatcherDepartment;

    @OneToOne
    @JoinColumn(name = "driver_department_id")
    private DriverDepartment driverDepartment;

    @OneToOne
    @JoinColumn(name = "heldDesk_service_department_id")
    private HelpDeskServiceDepartment helpDeskServiceDepartment;

    @OneToOne
    @JoinColumn(name = "railwayRepair_department_id")
    private RailwayRepairDepartment railwayRepairDepartment;

    @OneToOne
    @JoinColumn(name = "trainRepairmen_department_id")
    private TrainRepairmenDepartment trainRepairmenDepartment;

    @OneToOne
    @JoinColumn(name = "trainServiceman_department_id")
    private TrainServicemanDepartment trainServiceman;
//
//    @OneToOne(mappedBy = "trainDepartments")
//    private Worker worker;

    public TrainDepartments(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CashierDepartment getCashierDepartment() {
        return cashierDepartment;
    }

    public void setCashierDepartment(CashierDepartment cashierDepartment) {
        this.cashierDepartment = cashierDepartment;
    }

    public DispatcherDepartment getDispatcherDepartment() {
        return dispatcherDepartment;
    }

    public void setDispatcherDepartment(DispatcherDepartment dispatcherDepartment) {
        this.dispatcherDepartment = dispatcherDepartment;
    }

    public DriverDepartment getDriverDepartment() {
        return driverDepartment;
    }

    public void setDriverDepartment(DriverDepartment driverDepartment) {
        this.driverDepartment = driverDepartment;
    }

    public HelpDeskServiceDepartment getHelpDeskServiceDepartment() {
        return helpDeskServiceDepartment;
    }

    public void setHelpDeskServiceDepartment(HelpDeskServiceDepartment helpDeskServiceDepartment) {
        this.helpDeskServiceDepartment = helpDeskServiceDepartment;
    }

    public RailwayRepairDepartment getRailwayRepairDepartment() {
        return railwayRepairDepartment;
    }

    public void setRailwayRepairDepartment(RailwayRepairDepartment railwayRepairDepartment) {
        this.railwayRepairDepartment = railwayRepairDepartment;
    }

    public TrainRepairmenDepartment getTrainRepairmenDepartment() {
        return trainRepairmenDepartment;
    }

    public void setTrainRepairmenDepartment(TrainRepairmenDepartment trainRepairmenDepartment) {
        this.trainRepairmenDepartment = trainRepairmenDepartment;
    }

    public TrainServicemanDepartment getTrainServiceman() {
        return trainServiceman;
    }

    public void setTrainServiceman(TrainServicemanDepartment trainServiceman) {
        this.trainServiceman = trainServiceman;
    }

    public TrainDepartments(CashierDepartment cashierDepartment, DispatcherDepartment dispatcherDepartment, DriverDepartment driverDepartment, HelpDeskServiceDepartment helpDeskServiceDepartment, RailwayRepairDepartment railwayRepairDepartment, TrainRepairmenDepartment trainRepairmenDepartment, TrainServicemanDepartment trainServiceman) {
        this.cashierDepartment = cashierDepartment;
        this.dispatcherDepartment = dispatcherDepartment;
        this.driverDepartment = driverDepartment;
        this.helpDeskServiceDepartment = helpDeskServiceDepartment;
        this.railwayRepairDepartment = railwayRepairDepartment;
        this.trainRepairmenDepartment = trainRepairmenDepartment;
        this.trainServiceman = trainServiceman;
    }
}
