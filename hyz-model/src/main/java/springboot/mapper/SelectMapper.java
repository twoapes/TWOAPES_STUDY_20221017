package springboot.mapper;

import springboot.domain.student.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author add by huyingzhao
 * 2023-04-17 10:52
 */
@Mapper
public interface SelectMapper {
    /**
     * @param id id
     * @return getStudent
     */
    @Select("SELECT s.id, s.name, s.age FROM STUDENT s WHERE s.id = #{id}")
    StudentVO getStudent(int id);
}
