package ua.coursework.train_station.repositories.workerRepositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.departments.TrainDepartments;

import java.util.List;

@Repository
public interface WorkerRepository extends CrudRepository<Worker,Long> {

    Page<Worker>findAll(Pageable pageable);
    Iterable<Worker>findAll();
    List<? extends Worker>findAllByExperience(int experience);
    List<? extends Worker>findAllBySex(Gender gender);
    List<? extends Worker>findAllByChildrenAmount(int childrenAmount);
    List<? extends Worker>findAllBySalary(int salary);
}
