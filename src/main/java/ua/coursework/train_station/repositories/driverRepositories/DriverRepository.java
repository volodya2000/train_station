package ua.coursework.train_station.repositories.driverRepositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<Driver,Long> {

        Driver findById(long id);
        @Query(nativeQuery = true,value = "select * from drivers inner join worker on drivers.id = worker.id where year_of_medical_check >=?1")
        Page<Driver>findByYearOfMedicalCheckGreaterThanEqual(int medicalCheck,Pageable pageable);//+

        @Query(nativeQuery = true,value = "select count(*) from drivers inner join worker on drivers.id = worker.id where year_of_medical_check>=?1")
        int countDriverByMedicalCheck(int year);


        Page<Driver>findAll();

        @Query(nativeQuery = true,value = "select  * from drivers inner join worker w on drivers.id = w.id")
        Page<Driver>findAll(Pageable pageable);

        @Query(nativeQuery = true,value = "select count(*)from drivers inner join worker w on drivers.id = w.id")
        int countAll();

        @Query(nativeQuery = true,value = "select * from drivers join worker w on drivers.id = w.id " +
                "where w.experience=?1")
        Page<Driver>findAllByExperience(int experience,Pageable pageable);

        @Query(nativeQuery = true,value = "select count(*) from drivers join worker w on drivers.id = w.id " +
                "where w.experience=?1")
        int countAllByExperience(int experience);


        Page<Driver>findAllBySex(Gender gender,Pageable pageable);

        @Query(nativeQuery = true,value = "select count(*) from drivers join worker w on drivers.id = w.id " +
                "where w.sex=?1")
        int countAllBySex(String gender);

        @Query(nativeQuery = true,value = "select * from drivers join worker w on drivers.id = w.id " +
                "where w.age=?1")
        Page<Driver> findAllByAge(int age, Pageable pageable);

        @Query(nativeQuery = true,value = "select count(*) from drivers join worker w on drivers.id = w.id " +
                "where w.age=?1")
        int countAllByAge(int age);

        @Query(nativeQuery = true,value = "select * from drivers join  worker w on drivers.id = w.id " +
                "where w.children_amount=?1")
        Page<Driver>findAllByChildrenAmount(int childrenAmount,Pageable pageable);

        @Query(nativeQuery = true,value = "select count(*) from drivers join  worker w on drivers.id = w.id " +
                "where w.children_amount=?1")
        int countAllByChildrenAmount(int amount);

        @Query(nativeQuery = true,value = "select * from drivers join worker w on drivers.id = w.id " +
                "where w.salary=?1")
        Page<Driver>findAllBySalary(int salary,Pageable pageable);

        @Query(nativeQuery = true,value = "select count(*) from drivers join worker w on drivers.id = w.id " +
                "where w.salary=?1")
        int countAllBySalary(int salary);

        @Query(nativeQuery = true,value = "select * from drivers inner join worker on drivers.id = worker.id join driver_brigades db on drivers.brigade_id = db.id where " +
                "db.name=?1")
        Page<Driver>findAllByBrigade(String  driverBrigade,Pageable pageable);


        @Query(nativeQuery = true,value = "select * from drivers join worker w on drivers.id = w.id " +
                "join driver_brigades db on drivers.brigade_id = db.id where db.name=?1 and w.age=?2")
        Page<Driver>findAllByBrigadeAndAge(String brigade,int age,Pageable pageable);


        @Query(nativeQuery = true,value = "select * from drivers join worker w on drivers.id = w.id " +
                "join driver_brigades db on drivers.brigade_id = db.id where db.name=?1 and w.salary=?2")
        Page<Driver>findAllByBrigadeAndSalary(String brigade,int salary,Pageable pageable);

        @Query(nativeQuery = true,value = "delete  from drivers where year_of_medical_check <?1")
        void deleteByMedicalCheck(int year);
}
