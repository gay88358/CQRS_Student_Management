package student.write.createStudent;

import common.Command;

public class CreateStudentCommand implements Command {
    private final String name;

    public CreateStudentCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
