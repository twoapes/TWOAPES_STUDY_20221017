package springboot.mapper;

import domain.StudentTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author huyingzhao
 * 2022-01-23 19:00:06
 */
@Mapper
public interface ControllerSelectMapper {
    /**
     * @param id id
     * @return getStudent
     */
    @Select("SELECT s.id, s.name, s.age FROM student s WHERE s.id = #{id}")
    StudentTO getStudent(int id);
}