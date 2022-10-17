package jdbc.di;

import core.AppCore;
import dto.StudentTO;
import jdbc.dao.JDBCDao;
import jdbc.pojo.ParameterPOJO;
import jdbc.service.AppConfig;
import jdbc.service.JdbcSelectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author add by huyingzhao
 * 2022-09-03 17:34
 */
@Slf4j
public class JDBCDI {
    public static void jdbc1() {
        log.info("\n" + "---------------[using JdbcTemplate]Spring JDBC---------------" + "\n");
        ApplicationContext context = AppCore.open("jdbc/jdbc.xml");
        JDBCDao jdbcDao = jdbcDao(context);
        log.info("id=1:" + jdbcDao.findId(1).toString());
        log.info("id=2:" + jdbcDao.findId(2).toString());
        log.info("id>0:" + jdbcDao.findIds(0).toString());
        log.info("id>0:" + jdbcDao.findIdMap(0).toString());
//        log.info("insert:" + jdbcDao.insert());
//        log.info("update:" + jdbcDao.update());
//        log.info("delete:" + jdbcDao.delete());
        AppCore.close(context);
    }

    /**
     * @author add by huyingzhao
     * 2022-07-26 23:26
     */
    public static void jdbc2() {
        try {
            log.info("\n" + "---------------[using original JDBC]JDBC---------------" + "\n");
            ApplicationContext context = AppCore.openClass(AppConfig.class);
            JdbcSelectService selectService = context.getBean(JdbcSelectService.class);
            selectService.open();
            ParameterPOJO parameterPOJO = new ParameterPOJO();
            parameterPOJO.setSql("select s.ID, NAME, AGE from STUDENT s");
            StudentTO studentTO = new StudentTO();
            List<StudentTO> studentTOS = selectService.selectResult(parameterPOJO, studentTO);
            for (StudentTO student : studentTOS) {
                log.info(student.toString());
            }

            List<Map<String, Object>> mapList = selectService.selectResultMap(parameterPOJO);
            for (Map<String, Object> student2 : mapList) {
                log.info(student2.toString());
            }

            log.info(String.valueOf(selectService.isConnected()));
            log.info(String.valueOf(parameterPOJO.getI()));
            selectService.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * @param applicationContext applicationContext
     * @return jdbcDao
     */
    private static JDBCDao jdbcDao(ApplicationContext applicationContext) {
        JDBCDao jdbcDao = null;
        if (applicationContext != null) {
            jdbcDao = applicationContext.getBean("jdbcDao", JDBCDao.class);
        }
        return jdbcDao;
    }
}