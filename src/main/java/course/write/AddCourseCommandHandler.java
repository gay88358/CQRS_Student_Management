package course.write;

import common.CommandHandler;
import common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

public class AddCourseCommandHandler implements CommandHandler<AddCourseCommand> {

    private final CourseRepository repository;

    AddCourseCommandHandler(CourseRepository repository) {
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
