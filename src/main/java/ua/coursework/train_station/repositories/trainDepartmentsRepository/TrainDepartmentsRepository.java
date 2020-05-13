package ua.coursework.train_station.repositories.trainDepartmentsRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.departments.TrainDepartments;

import java.util.List;

@Repository
public interface TrainDepartmentsRepository extends CrudRepository<TrainDepartments,Long> {

}
