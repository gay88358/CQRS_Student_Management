package course.write.domain;

public interface CourseRepository {
    Course findBy(Long courseId);
    void add(Course course);
}
