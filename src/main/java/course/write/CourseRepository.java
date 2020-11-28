package course.write;

public interface CourseRepository {
    Course findBy(Long courseId);
    void add(Course course);
}
