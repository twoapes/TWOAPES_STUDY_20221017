package jdbc.service;


import jdbc.pojo.ParameterPOJO;

import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-06-07 9:07
 */
public interface JdbcExecuteService extends JdbcConnectService {
    /**
     * @param parameterPOJO parameterPOJO
     * @author add by huyingzhao
     * 2022-06-07 9:18
     */
    void execute(ParameterPOJO parameterPOJO);

    /**
     * @param updateEntities updateEntities
     * @return executeBatch
     * @author add by huyingzhao
     * 2022-06-07 9:18
     */
    List<ParameterPOJO> executeBatch(List<ParameterPOJO> updateEntities);

    /**
     * @param updateEntities updateEntities
     * @author add by huyingzhao
     * 2022-06-07 9:18
     */
    void execute(List<ParameterPOJO> updateEntities);

    /**
     * @param parameterPOJO parameterPOJO
     * @param o             o
     * @author add by huyingzhao
     * 2022-06-07 9:17
     */
    void updateBlob(ParameterPOJO parameterPOJO, Object o);
}