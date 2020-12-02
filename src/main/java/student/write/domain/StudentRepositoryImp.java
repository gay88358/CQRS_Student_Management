package student.write.domain;

import common.JPAGenericRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import student.write.domain.StudentRepository;
import student.write.domain.Student;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Primary
public class StudentRepositoryImp extends JPAGenericRepository<Student> implements StudentRepository {


    public StudentRepositoryImp() {
        super(Student.class);
    }

    @Override
    public Student findBy(long id) {
        return super.findBy(id);
    }

    @Override
    public void add(Student student) {
        super.add(student);
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>)super.findAll();
    }
}





