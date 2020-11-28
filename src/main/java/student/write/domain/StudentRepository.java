package student.write.domain;

import student.write.domain.Student;

import java.util.List;

public interface StudentRepository {
    Student findBy(long id);
    void add(Student student);
    List<Student> findAll();
}
