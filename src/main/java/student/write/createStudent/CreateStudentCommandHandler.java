package student.write.createStudent;

import common.CommandHandler;
import common.Result;
import student.write.domain.Student;
import student.write.domain.StudentRepository;

public class CreateStudentCommandHandler implements CommandHandler<CreateStudentCommand> {
    private final StudentRepository repository;

    public CreateStudentCommandHandler(StudentRepository repository) {
        this.repository = repository;
    }

    public Result<Long> handle(CreateStudentCommand command) {
        Student student = new Student(command.getName());
        this.repository.add(student);
        return Result.success(student.getId());
    }
}
