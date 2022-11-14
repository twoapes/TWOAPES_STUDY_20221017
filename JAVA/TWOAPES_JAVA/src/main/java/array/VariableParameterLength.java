package array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:58
 * list of variable length parameters
 */
@Slf4j
public class VariableParameterLength {
    public static void variableParameterLength(double... numbers) {
        if (numbers.length == 0) {
            log.warn("list must not empty");
        }

        double result = numbers[0];
        for (double number : numbers) {
            if (result < number) {
                result = number;
            }
        }

        log.info("numbers:[{}] result:{}" ,Arrays.toString(numbers), result);
    }
}
