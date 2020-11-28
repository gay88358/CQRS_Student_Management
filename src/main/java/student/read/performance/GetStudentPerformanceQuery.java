package student.read.performance;

import common.Query;

public class GetStudentPerformanceQuery implements Query<StudentPerformanceDto> {
    private Long studentId;

    public GetStudentPerformanceQuery(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }
}
