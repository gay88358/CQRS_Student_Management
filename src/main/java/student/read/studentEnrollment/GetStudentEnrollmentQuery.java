package student.read.studentEnrollment;

import common.Query;

import java.util.List;

public class GetStudentEnrollmentQuery implements Query<List<EnrollmentDto>> {
    private Long studentId;

    public GetStudentEnrollmentQuery(Long studentId) {

        this.studentId = studentId;
    }

    public Object getStudentId() {
        return this.studentId;
    }
}
