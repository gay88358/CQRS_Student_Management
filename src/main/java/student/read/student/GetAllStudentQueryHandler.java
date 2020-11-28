package student.read.student;

import common.QueryHandler;
import common.Result;
import student.write.domain.Student;
import student.write.domain.StudentRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetAllStudentQueryHandler implements QueryHandler<List<StudentDto>, GetAllStudentQuery> {

    private StudentRepository studentRepository;

    public GetAllStudentQueryHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Result<List<StudentDto>> handle(GetAllStudentQuery getAllStudentQuery) {
        List<StudentDto> studentDtos = this.studentRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(toList());
        return Result.success(studentDtos);
    }

    private StudentDto toDto(Student student) {
        return new StudentDto(student.getName());
    }
}
