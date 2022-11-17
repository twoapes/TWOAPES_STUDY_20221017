package variable;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 *         2022-06-11 16:13
 *         variable type
 */
@Slf4j
@Setter
public class VariableType {

    // static variable
    private static double staticVariable;

    /*
     * instance methods can use static variables
     */
    private void instanceMethod1() {
        log.info("instanceMethod1:{}",staticVariable);
    }

    /**
     * static methods can use static variables
     */
    private static void staticMethod1() {
        log.info("staticMethod1:{}",staticVariable);
    }

//    private double instanceVariable;

    /**
     * instance methods can use instance variables
     */
    private void instanceMethod2() {
        log.info("instanceMethod2:{}",staticVariable);
    }

    /*
     * static methods cannot use instance variables
     */
    /// private static double staticMethod2() {
    // return instanceVariable;
    // }

    public void variableType() {
        instanceMethod1();
        staticMethod1();
        instanceMethod2();
        // staticMethod2();
        log.info("instance variables are not shared, while static variables are shared\n" +
                "static variables can be accessed through instance methods and static methods\n" +
                "instance variables can only be accessed by instance methods\n");
    }

    public static void variableTypeStatic() {
        // instanceMethod1();
        staticMethod1();
        /// instanceMethod2();
        // staticMethod2();
        log.info("instance variables are not shared, while static variables are shared\n" +
                "static variables can be accessed through instance methods and static methods\n" +
                "instance variables can only be accessed by instance methods\n");
    }
}