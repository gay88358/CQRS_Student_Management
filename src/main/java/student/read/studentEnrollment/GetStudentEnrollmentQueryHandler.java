package student.read.studentEnrollment;

import common.QueryHandler;
import common.Result;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class GetStudentEnrollmentQueryHandler implements QueryHandler<List<EnrollmentDto>, GetStudentEnrollmentQuery> {
    private final EntityManager entityManager;

    public GetStudentEnrollmentQueryHandler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Result<List<EnrollmentDto>> handle(GetStudentEnrollmentQuery getStudentEnrollmentQuery) {
        List<EnrollmentDto> enrollmentDtos =
                this.entityManager
                .createQuery(
                        "SELECT new student.read.studentEnrollment.EnrollmentDto(s.name, c.name, e.grade) " +
                                "FROM Enrollment e " +
                                "JOIN Course c ON c.id = e.course.id " +
                                "JOIN Student s ON s.id = e.student.id " +
                                "Where e.student.id = :student_id",
                        EnrollmentDto.class
                        )
                .setParameter("student_id", getStudentEnrollmentQuery.getStudentId())
                .getResultList();

        return Result.success(enrollmentDtos);

    }
}
