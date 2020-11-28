package course.write.addCourse;

import common.CommandHandler;
import common.Result;
import course.write.domain.Course;
import course.write.domain.CourseRepository;

import javax.transaction.Transactional;

public class AddCourseCommandHandler implements CommandHandler<AddCourseCommand> {

    private final CourseRepository repository;

    public AddCourseCommandHandler(CourseRepository repository) {
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
