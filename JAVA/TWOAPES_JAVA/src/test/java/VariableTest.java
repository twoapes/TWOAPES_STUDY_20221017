import org.junit.Test;
import variable.*;

/**
 * @author add by huyingzhao
 * 2022-09-01 11:36
 * variable
 */
public class VariableTest {
    /**
     * test Scope
     *
     * @author add by huyingzhao
     * 2022-09-12 22:57
     */
    @Test
    public void ScopeTest() {
        Scope.scope();
    }

    /**
     * test VariableType
     *
     * @author add by huyingzhao
     * 2022-09-12 23:00
     */
    @Test
    public void variableTypeTest() {
        VariableType.variableTypeStatic();
        VariableType type= new VariableType();
        type.variableType();
    }

    /**
     * test PrimitiveType
     *
     * @author add by huyingzhao
     * 2022-09-12 23:04
     */
    @Test
    public void primitiveTypeTest() {
        PrimitiveType.primitiveType();
    }

    /**
     * test NumericalLiterals
     *
     * @author add by huyingzhao
     * 2022-09-12 23:04
     */
    @Test
    public void numericalLiteralsTest() {
        NumericalLiterals.numericalLiterals();
    }

    /**
     * test MathFunction
     *
     * @author add by huyingzhao
     * 2022-09-13 10:09
     */
    @Test
    public void mathFunctionTest() {
        MathFunction.mathFunction();
    }

    /**
     * test BigValue
     *
     * @author add by huyingzhao
     * 2022-09-13 10:15
     */
    @Test
    public void bigValueTest() {
        BigValue.bigValue();
    }

    /**
     * test ForceConversion
     *
     * @author add by huyingzhao
     * 2022-09-13 10:20
     */
    @Test
    public void ForceConversionTest() {
        ForceConversion.forceConversion();
    }

    /***
     * test Escape
     *
     * @author add by huyingzhao
     * 2022-09-13 10:20
     */
    @Test
    public void escapeTest() {
        Escape.escape();
    }

    /**
     * test DefaultValue
     *
     * @author add by huyingzhao
     * 2022-09-13 10:38
     */
    @Test
    public void defaultValueTest() {
        DefaultValue.defaultValue();
    }

    /**
     * test CharacterType
     *
     * @author add by huyingzhao
     * 2022-09-13 10:40
     */
    @Test
    public void characterTypeTest() {
        CharacterType.characterType();
    }

    /**
     * test BlockScope
     *
     * @author add by huyingzhao
     * 2022-09-13 10:42
     */
    @Test
    public void blockScopeTest() {
        BlockScope.blockScope();
    }

    /**
     * test AutomaticUnpacking
     *
     * @author add by huyingzhao
     * 2022-09-13 10:42
     */
    @Test
    public void automaticUnpackingTest() {
        AutomaticUnpacking.automaticUnpacking();
    }
}