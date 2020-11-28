package course.read;

import common.Query;
import common.QueryHandler;
import common.Result;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class GetAllCourseHandler implements QueryHandler<List<CourseDto>, GetAllCourseQuery> {

    @PersistenceContext
    EntityManager entityManager;


    public GetAllCourseHandler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Result<List<CourseDto>> handle(GetAllCourseQuery getAllCourseQuery) {
        List<CourseDto> courseDtos = this.entityManager
                .createQuery(
                        "select new course.read.CourseDto(c.name) from Course c",
                        CourseDto.class
                )
                .getResultList();
        return Result.success(
                courseDtos
        );
    }
}
