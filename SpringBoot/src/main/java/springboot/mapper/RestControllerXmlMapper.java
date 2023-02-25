package springboot.mapper;

import domain.StudentTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RestControllerXmlMapper {
    /**
     * @param id id
     * @return getStudentForXml
     */
    StudentTO getStudentForXml(int id);
}