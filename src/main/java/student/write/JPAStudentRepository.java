package student.write;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import student.write.domain.StudentRepository;
import student.write.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Primary
public class JPAStudentRepository implements StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Student findBy(long id) {
        return this.entityManager.find(Student.class, new Long(id));
    }

    @Override
    public void add(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
