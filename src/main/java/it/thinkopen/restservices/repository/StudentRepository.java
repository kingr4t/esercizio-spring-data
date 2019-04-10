package it.thinkopen.restservices.repository;

import it.thinkopen.restservices.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student, Long> {

    long countBySurname(String surname);

    Collection<Student> findAllStudentByName(String name);

    Student findStudentBySurname(String surname);

    @Query("SELECT s FROM Student s WHERE s.name = :name")
    Collection<Student> finder(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.fiscalCode = :cf")
    Collection<Student> finderCF(@Param("cf") String cf);

    @Query(value = "SELECT * FROM student as s WHERE s.cf = ?1", nativeQuery = true)
    Collection<Student> finderCF2(String cf);


}
