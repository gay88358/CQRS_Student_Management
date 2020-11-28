package student.write.enrollCourse;

import common.CommandHandler;
import common.Result;
import course.write.Course;
import course.write.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.write.domain.Student;
import student.write.domain.StudentRepository;

import javax.transaction.Transactional;

@Component
public class EnrollCourseCommandHandler implements CommandHandler<EnrollCourseCommand> {
    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final CourseRepository courseRepository;

    public EnrollCourseCommandHandler(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Result<Boolean> handle(EnrollCourseCommand enrollCourseCommand) {
        Student student = studentRepository.findBy(enrollCourseCommand.getStudentId());
        Course course = courseRepository.findBy(enrollCourseCommand.getCourseId());
        student.addEnrollment(course, enrollCourseCommand.getGrade());
        return Result.success(true);
    }
}
