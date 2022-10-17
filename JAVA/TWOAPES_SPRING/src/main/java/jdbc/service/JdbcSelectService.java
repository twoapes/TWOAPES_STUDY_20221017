package jdbc.service;

import jdbc.pojo.ParameterPOJO;

import java.util.List;
import java.util.Map;

/**
 * @author add by huyingzhao
 * 2022-06-06 23:19
 */
public interface JdbcSelectService extends JdbcConnectService{
    /**
     * @param parameterPOJO parameterPOJO
     * @return selectResultMap
     * @author add by huyingzhao
     * 2022-06-07 9:09
     */
     List<Map<String, Object>> selectResultMap(ParameterPOJO parameterPOJO);

    /**
     * @param parameterPOJO parameterPOJO
     * @param pojo        pojo
     * @return selectResult
     * @author add by huyingzhao
     * 2022-06-07 9:10
     */
    <T> List<T> selectResult(ParameterPOJO parameterPOJO, T pojo);

    /**
     * @param parameterPOJO parameterPOJO
     * @return selectOriginal
     * @author add by huyingzhao
     * 2022-06-07 9:11
     */
    Map<String, String> selectOriginal(ParameterPOJO parameterPOJO);
}