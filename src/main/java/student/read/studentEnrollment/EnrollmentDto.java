package student.read.studentEnrollment;

import student.write.domain.Grade;

import java.util.Objects;

public class EnrollmentDto {

    private final String name;
    private final String courseName;
    private final String grade;

    public EnrollmentDto(String name, String courseName, Grade grade) {

        this.name = name;
        this.courseName = courseName;
        this.grade = grade.toString();
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EnrollmentDto that = (EnrollmentDto) object;
        return Objects.equals(name, that.name) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, courseName, grade);
    }

    @Override
    public String toString() {
        return courseName + ":" + grade;
    }
}
