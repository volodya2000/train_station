package ua.coursework.train_station.repositories.trainRepairmanRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.trainRepairman.TrainRepairBrigades;

import java.util.List;

@Repository
public interface TrainRepairmanBrigadesRepository extends CrudRepository<TrainRepairBrigades,Long> {
    List<TrainRepairBrigades> findAll();
    TrainRepairBrigades findByName(String name);
}
