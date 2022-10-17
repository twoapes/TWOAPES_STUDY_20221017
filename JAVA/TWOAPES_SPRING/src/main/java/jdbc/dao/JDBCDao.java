package jdbc.dao;

import dto.StudentTO;
import lombok.Data;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author add by huyingzhao
 * 2022-09-03 17:55
 */
@Data
public class JDBCDao {
    private JdbcTemplate jdbcTemplate;

    /**
     * findOne
     *
     * @param id id
     * @return findId
     * @author add by huyingzhao
     * 2022-09-03 18:12
     */
    public StudentTO findId(Integer id) {
        String sql = "select s.ID, NAME, AGE from STUDENT s where s.ID=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(StudentTO.class), id);
    }

    /**
     * find
     *
     * @param id id
     * @return findIds
     * @author add by huyingzhao
     * 2022-09-03 18:12
     */
    public List<StudentTO> findIds(Integer id) {
        String sql = "select s.ID, NAME, AGE from STUDENT s where s.ID>?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentTO.class), id);
    }

    /**
     * @param id id
     * @return findIdMap
     * @author add by huyingzhao
     * 2022-09-03 18:12
     */
    public List<Map<String, Object>> findIdMap(Integer id) {
        String sql = "select s.ID, NAME, AGE from STUDENT s where s.ID>?";
        return jdbcTemplate.queryForList(sql, id);
    }

    public int insert() {
        int index = insert(3, "WangWu", 23);
        index += insert(4, "LiuLiu", 18);
        return index;
    }

    /**
     * add
     *
     * @param id id
     * @return insert
     * @author add by huyingzhao
     * 2022-09-03 18:12
     */
    private int insert(Integer id, String name, Integer age) {
        String sql = "INSERT INTO STUDENT (ID, NAME, AGE) VALUES (?, ?, ?)";
        Object[] objects = {id, name, age};
        return jdbcTemplate.update(sql, objects);
    }


    /**
     * @return update
     * @author method add by huyingzhao
     * 2022-10-14 10:57
     */
    public int update() {
        int index = update(3, "WangWu", 19);
        index += update(4, "LiuLiu", 21);
        return index;
    }

    /**
     * 更新
     *
     * @param id id
     * @return StudentDTO
     * @author add by huyingzhao
     * 2022-09-03 18:12
     */
    private int update(Integer id, String name, Integer age) {
        String sql = "UPDATE STUDENT s set s.NAME= ?,s.AGE=?   where s.ID=? ";
        Object[] objects = {name, age, id};
        return jdbcTemplate.update(sql, objects);
    }

    public int delete() {
        int index = delete(3);
        index += delete(4);
        return index;
    }

    /**
     * delete
     *
     * @param id id
     * @return StudentDTO
     * @author add by huyingzhao
     * 2022-09-03 18:12
     */
    private int delete(Integer id) {
        String sql = "DELETE FROM STUDENT s WHERE s.ID= ? ";
        return jdbcTemplate.update(sql, id);
    }
}