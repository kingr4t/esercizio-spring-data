package it.thinkopen.restservices.repository;


import it.thinkopen.restservices.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository
public class StudentCustomRepository {

    @PersistenceContext
    private EntityManager em;

    public Collection<Student> getStudentsByName(String name, String surname) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> student = cq.from(Student.class);
        Predicate namePredicate = cb.equal(student.get("name"), name);
        Predicate surnamePredicate = cb.equal(student.get("surname"), surname);
        cq.where(namePredicate, surnamePredicate);

        TypedQuery<Student> query = em.createQuery(cq);
        return query.getResultList();
    }
}
