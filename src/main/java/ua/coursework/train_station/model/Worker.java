package ua.coursework.train_station.model;

import ua.coursework.train_station.model.departments.TrainDepartments;

import javax.persistence.*;

@Entity
@Table(name = "Worker")
@Inheritance(strategy = InheritanceType.JOINED)
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String surname;

    private int age;

    private int salary;

    private int childrenAmount;

    private int experience;

    @Enumerated(value = EnumType.STRING)
    private Gender sex;
//
//    @OneToOne
//    @JoinColumn(name = "train_department_id")
//    private TrainDepartments trainDepartments;
    public Worker()
    {}

    public Worker(String name, String surname, int age, int salary, int childrenAmount,
                  int experience, Gender sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.childrenAmount = childrenAmount;
        this.experience = experience;
        this.sex = sex;
    }

    public Worker(String name, String surname, int age, int salary, int childrenAmount, int experience, Gender sex, TrainDepartments trainDepartments) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.childrenAmount = childrenAmount;
        this.experience = experience;
        this.sex = sex;
      //  this.trainDepartments = trainDepartments;
    }

//
//    public TrainDepartments getTrainDepartments() {
//        return trainDepartments;
//    }
//
//    public void setTrainDepartments(TrainDepartments trainDepartments) {
//        this.trainDepartments = trainDepartments;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getChildrenAmount() {
        return childrenAmount;
    }

    public void setChildrenAmount(int childrenAmount) {
        this.childrenAmount = childrenAmount;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;

        if (age != worker.age) return false;
        if (salary != worker.salary) return false;
        if (childrenAmount != worker.childrenAmount) return false;
        if (experience != worker.experience) return false;
        if (!id.equals(worker.id)) return false;
        if (!name.equals(worker.name)) return false;
        if (!surname.equals(worker.surname)) return false;
        return sex == worker.sex;
    }

//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + name.hashCode();
//        result = 31 * result + surname.hashCode();
//        result = 31 * result + age;
//        result = 31 * result + salary;
//        result = 31 * result + childrenAmount;
//        result = 31 * result + experience;
//        result = 31 * result + sex.hashCode();
//        return result;
//    }
}
