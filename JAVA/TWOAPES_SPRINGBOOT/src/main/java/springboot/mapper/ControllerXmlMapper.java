package springboot.mapper;

import entity.StudentTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ControllerXmlMapper {
    /**
     * @param id id
     * @return getStudentForXml
     */
    StudentTO getStudentForXml(int id);
}
