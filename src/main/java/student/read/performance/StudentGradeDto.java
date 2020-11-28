package student.read.performance;

import student.write.domain.Grade;

public class StudentGradeDto {

    private final String studentName;
    private final Grade grade;

    public StudentGradeDto(String studentName, Grade grade) {

        this.studentName = studentName;
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getStudentName() {
        return studentName;
    }

}
