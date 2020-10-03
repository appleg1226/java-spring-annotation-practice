package parameterReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ParamManager {

    public void doParamTest(int num1, int num2) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ParamService paramService = new ParamService();

        Method method = paramService.getClass().getMethod("paramTest", Integer.class, Integer.class);

        List<Integer> paramList = new ArrayList<>();

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        for (Annotation[] annotations: parameterAnnotations) {
            for(Annotation annotation: annotations){
                if(annotation instanceof MaxNum){
                    MaxNum maxNum = (MaxNum) annotation;
                    paramList.add(maxNum.value());
                }
            }
        }

        int resultNum1 = Integer.max(num1, paramList.get(0));
        int resultNum2 = Integer.max(num2, paramList.get(1));
        method.invoke(paramService, resultNum1, resultNum2);
    }

}
