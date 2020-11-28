package student.read.performance;

import common.QueryHandler;
import common.Result;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class GetStudentPerformanceQueryHandler implements QueryHandler<StudentPerformanceDto, GetStudentPerformanceQuery> {
    @PersistenceContext
    private EntityManager entityManager;

    public GetStudentPerformanceQueryHandler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Result<StudentPerformanceDto> handle(GetStudentPerformanceQuery getStudentPerformanceQuery) {
        List<StudentGradeDto> studentGradeDtos = entityManager.createQuery(
                "SELECT new student.read.performance.StudentGradeDto(s.name, e.grade) " +
                        "FROM Enrollment e " +
                        "JOIN Student s ON s.id = e.student.id " +
                        "WHERE e.student.id = :studentId",
                StudentGradeDto.class
        )
        .setParameter("studentId", getStudentPerformanceQuery.getStudentId())
        .getResultList();
        return Result.success(new StudentPerformanceDto(studentGradeDtos));
    }
}
