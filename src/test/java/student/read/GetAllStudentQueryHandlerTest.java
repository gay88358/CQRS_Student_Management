package student.read;

import common.Result;
import org.junit.Test;
import student.read.student.GetAllStudentQuery;
import student.read.student.GetAllStudentQueryHandler;
import student.read.student.StudentDto;
import student.write.domain.Student;
import student.write.domain.StudentRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GetAllStudentQueryHandlerTest {


    @Test
    public void get_all_student() {
        // Arrange
        GetAllStudentQuery query = new GetAllStudentQuery();
        StudentRepository fakeStudentRepository = new FakeStudentRepository();
        GetAllStudentQueryHandler handler = new GetAllStudentQueryHandler(fakeStudentRepository);
        // Act
        Result<List<StudentDto>> result = handler.handle(query);
        // Assert
        assertStudentDto(result);
    }

    private void assertStudentDto(Result<List<StudentDto>> result) {
        List<StudentDto> studentDtos = result.getValue();
        List<StudentDto> expectedStudentDtos = createExpectedStudentDtos();
        assertEquals(2, studentDtos.size());
        for (int i = 0; i < studentDtos.size(); i++) {
            assertEquals(studentDtos.get(i), expectedStudentDtos.get(i));
        }
    }

    private List<StudentDto> createExpectedStudentDtos() {
        return Arrays.asList(
                new StudentDto("Z-Xuan Hong"),
                new StudentDto("Amber")
        );
    }

    private static class FakeStudentRepository implements StudentRepository {

        @Override
        public Student findBy(long id) {
            return null;
        }

        @Override
        public void add(Student student) {

        }

        @Override
        public List<Student> findAll() {
            return Arrays.asList(new Student("Z-Xuan Hong"), new Student("Amber"));
        }
    }
}