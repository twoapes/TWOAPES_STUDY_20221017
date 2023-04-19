package springboot.mapper;

import springboot.domain.student.StudentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XmlMapper {
    /**
     * @param id id
     * @return getStudentForXml
     */
    StudentVO getStudent(int id);
}
