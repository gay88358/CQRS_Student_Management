package course.write.addCourse;

import common.CommandHandler;
import common.Result;
import course.write.domain.Course;
import course.write.domain.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddCourseCommandHandler implements CommandHandler<AddCourseCommand> {

    private final CourseRepository repository;

    public AddCourseCommandHandler(
            @Autowired
                    CourseRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Result<Long> handle(AddCourseCommand addCourseCommand) {
        Course course = new Course(addCourseCommand.getName());
        repository.add(course);
        return Result.success(course.getId());
    }
}
