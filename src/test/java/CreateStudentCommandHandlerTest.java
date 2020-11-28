import common.Result;
import course.StudentEnrollmentConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import student.write.JPAStudentRepository;
import student.write.createStudent.CreateStudentCommand;
import student.write.createStudent.CreateStudentCommandHandler;
import student.write.domain.Student;
import student.write.domain.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = {StudentEnrollmentConfig.class})
public class CreateStudentCommandHandlerTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void create_student() {
        // Arrange
        StudentRepository repository = new JPAStudentRepository(entityManager);
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
}