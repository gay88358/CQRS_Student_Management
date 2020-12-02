package student.write;

import common.IntegrationTest;
import common.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import student.write.createStudent.CreateStudentCommand;
import student.write.createStudent.CreateStudentCommandHandler;
import student.write.domain.Student;
import student.write.domain.StudentRepository;
import student.write.domain.StudentRepositoryImp;


import static org.junit.Assert.*;


public class CreateStudentCommandHandlerTest extends IntegrationTest {


    @Autowired
    private StudentRepository repository;

    @Test
    public void create_student() {
        // Arrange
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