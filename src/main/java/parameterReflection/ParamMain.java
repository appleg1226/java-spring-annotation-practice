package parameterReflection;

import java.lang.reflect.InvocationTargetException;

public class ParamMain {
    public static void main() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ParamManager paramManager = new ParamManager();
        paramManager.doParamTest(12, 31);
    }
}
