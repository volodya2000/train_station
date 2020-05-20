package ua.coursework.train_station.repositories.cashierRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierBrigades;

@Repository
public interface CashierRepository extends CrudRepository<Cashier,Long> {
    Page<Cashier> findAll();

    @Query(nativeQuery = true,value = "select * from cashier")
    Page<Cashier>findAll(Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from cashier")
    int allCashier();

    @Query(nativeQuery = true,value = "select * from cashier join worker w on cashier.id = w.id " +
            "where w.experience=?1")
    Page<Cashier>findAllByExperience(int experience,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from cashier join worker w on cashier.id = w.id " +
            "where w.experience=?1")
    int countAllByExperience(int experience);

    Page<Cashier>findAllBySex(Gender gender,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from cashier join worker w on cashier.id = w.id " +
            "where w.sex=?1")
    int countAllBySex(String gender);

    @Query(nativeQuery = true,value = "select * from cashier join worker w on cashier.id = w.id " +
            "where w.age=?1")
    Page<Cashier> findAllByAge(int age, Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from cashier join worker w on cashier.id = w.id " +
            "where w.age=?1")
    int countAllByAge(int age);

    @Query(nativeQuery = true,value = "select * from cashier join  worker w on cashier.id = w.id " +
            "where w.children_amount=?1")
    Page<Cashier>findAllByChildrenAmount(int childrenAmount,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from cashier join  worker w on cashier.id = w.id " +
            "where w.children_amount=?1")
    int countAllByChildrenAmount(int amount);

    @Query(nativeQuery = true,value = "select * from cashier join worker w on cashier.id = w.id " +
            "where w.salary=?1")
    Page<Cashier>findAllBySalary(int salary,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from cashier join worker w on cashier.id = w.id " +
            "where w.salary=?1")
    int countAllBySalary(int salary);
    Page<Cashier>findAllByBrigade(CashierBrigades CashierBrigade, Pageable pageable);
    Page<Cashier>findAllByBrigadeAndAge(CashierBrigades brigade, int age, Pageable pageable);
    Page<Cashier>findAllByBrigadeAndSalary(CashierBrigades brigade,int salary,Pageable pageable);
}
