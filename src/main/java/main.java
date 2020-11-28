import common.CommandHandler;
import common.Result;
import course.write.addCourse.AddCourseCommand;
import course.write.addCourse.AddCourseCommandHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import student.write.domain.StudentRepository;


public class main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(StudentEnrollmentConfig.class);
        AddCourseCommandHandler handler = (AddCourseCommandHandler)context.getBean("addCourseCommandHandler");
        Result<Long> result =  handler.handle(new AddCourseCommand("OOS"));
        System.out.println(result.getValue());
    }
}
