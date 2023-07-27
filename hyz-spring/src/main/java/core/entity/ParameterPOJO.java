package core.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParameterPOJO {
    private String sql;
    private final List<Object> parameters;
    private int i;
    private boolean skip;

    public ParameterPOJO() {
        parameters = new ArrayList<>();
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @return ParameterPOJO
     */
    public ParameterPOJO addParameter(Object parameterPOJO) {
        if (parameterPOJO instanceof java.util.Date) {
            java.util.Date date = (java.util.Date) parameterPOJO;
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            parameters.add(sqlDate);
        } else {
            parameters.add(parameterPOJO);
        }

        return this;
    }

    public void clear() {
        parameters.clear();
    }
}
