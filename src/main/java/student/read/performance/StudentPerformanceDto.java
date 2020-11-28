package student.read.performance;

import student.write.domain.Grade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentPerformanceDto {
    private List<StudentGradeDto> studentGradeDtos;

    public StudentPerformanceDto(List<StudentGradeDto> studentGradeDtos) {
        this.studentGradeDtos = studentGradeDtos;
    }

    public String getStudentName() {
        return this.studentGradeDtos.get(0).getStudentName();
    }

    public int getStudentPerformance() {
        int sumPerformance = studentGradeDtos
                .stream()
                .map(StudentGradeDto::getGrade)
                .map(this::toPerformance)
                .reduce((a, b) -> a + b)
                .orElse(0);
        int averagePerformance = sumPerformance / studentGradeDtos.size();
        return averagePerformance;
    }

    private int toPerformance(Grade grade) {
        Map<Grade, Integer> performanceMap = new HashMap<>();
        performanceMap.put(Grade.A, 100);
        performanceMap.put(Grade.B, 90);
        performanceMap.put(Grade.C, 80);
        performanceMap.put(Grade.D, 70);
        return performanceMap.get(grade);
    }
}
