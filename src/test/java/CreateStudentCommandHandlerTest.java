import common.Result;
import org.junit.Test;
import student.write.createStudent.CreateStudentCommand;
import student.write.createStudent.CreateStudentCommandHandler;
import student.write.domain.Student;
import student.write.domain.StudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CreateStudentCommandHandlerTest {


    @Test
    public void create_student() {
        // Arrange
        StudentRepository repository = new FakeStudentRepository();
        CreateStudentCommandHandler handler = new CreateStudentCommandHandler(repository);
        CreateStudentCommand command = new CreateStudentCommand("Z-Xuan Hong");
        // Act
        Result result = handler.handle(command);
        // Assert
        long studentId = (Long)result.getValue();
        Student student = repository.findBy(studentId);
        assertEquals(student.getName(), "Z-Xuan Hong");
        assertEquals(student.getId(), studentId);
    }

    class FakeStudentRepository implements StudentRepository {
        Map<Long, Student> studentMap = new HashMap<Long, Student>();
        private long counter = 0L;
        public Student findBy(long id) {
            return studentMap.get(id);
        }

        public void add(Student student) {
            studentMap.put(student.getId(), student);
        }

        @Override
        public List<Student> findAll() {
            return null;
        }
    }


}