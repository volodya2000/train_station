package ua.coursework.train_station.repositories.trainServicemanRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.trainServiceman.TrainServicemanBrigades;

import java.util.List;

@Repository
public interface TrainServicemanBrigadeRepository extends CrudRepository<TrainServicemanBrigades,Long> {
    List<TrainServicemanBrigades> findAll();
    TrainServicemanBrigades findByName(String name);
}
