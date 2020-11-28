package course.read;

import course.write.Course;

import java.util.Objects;

public class CourseDto {
    private String name;

    public CourseDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CourseDto courseDto = (CourseDto) object;
        return Objects.equals(name, courseDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
