package ua.coursework.train_station.repositories.trainServicemanRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.trainServiceman.TrainServicemanBrigades;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Repository
public interface TrainServicemanBrigadeRepository extends CrudRepository<TrainServicemanBrigades,Long> {

    @Query(nativeQuery = true,value = "select * from train_serviceman")
    List<TrainServicemanBrigades> findAll();

    @Query(nativeQuery = true,value = "select count(*) from train_serviceman")
    int countAll();

    TrainServicemanBrigades findByName(String name);
}
