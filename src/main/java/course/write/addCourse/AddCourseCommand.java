package course.write.addCourse;

import common.Command;

public class AddCourseCommand implements Command {
    private String courseName;

    public AddCourseCommand(String courseName) {

        this.courseName = courseName;
    }

    public String getName() {
        return this.courseName;
    }
}
