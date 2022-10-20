package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 *         2022-06-11 16:13
 *         variable type
 */
@Slf4j
public class VariableType {

    // static variable
    private static double staticVariable;

    /*
     * instance methods can use static variables
     */
    private double instanceMethod1() {
        return staticVariable;
    }

    /**
     * static methods can use static variables
     */
    private static double staticMethod1() {
        return staticVariable;
    }

    private double instanceVariable;

    /**
     * instance methods can use instance variables
     */
    private double instanceMethod2() {
        return instanceVariable;
    }

    /*
     * static methods cannot use instance variables
     */
    // private static double staticMethod2() {
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
        // instanceMethod2();
        // staticMethod2();
        log.info("instance variables are not shared, while static variables are shared\n" +
                "static variables can be accessed through instance methods and static methods\n" +
                "instance variables can only be accessed by instance methods\n");
    }
}