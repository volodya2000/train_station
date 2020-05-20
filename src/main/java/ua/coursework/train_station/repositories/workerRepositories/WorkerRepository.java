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

    @Query(nativeQuery = true,value = "select * ,w.age,w.name,w.sex from train_departments join driver_department dd on train_departments.driver_department_id = dd.id " +
            "join drivers d on dd.head_of_department_id = d.id join worker w on d.id = w.id join cashier_department cd on train_departments.cashier_department_id = cd.id " +
            "join cashier c on cd.head_of_department_id = c.id join worker on c.id=worker.id")
    List<? extends Worker>findAllHeadOfDepartment();
    List<? extends Worker>findAllByExperience(int experience);
    List<? extends Worker>findAllBySex(Gender gender);
    List<? extends Worker>findAllByChildrenAmount(int childrenAmount);
    List<? extends Worker>findAllBySalary(int salary);
}
