package container;

import fieldReflection.Autowired;
import methodReflection.Before;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ContainerService {

    private static <T> T createInstance(Class<T> classType){
        try{
            return classType.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getObject(Class<T> tClass){
        T instance = createInstance(tClass);
        Stream.of(tClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Autowired.class))
                .forEach(field -> {
                    try{
                        Object fieldInstance = createInstance(field.getType());
                        field.setAccessible(true);
                        field.set(instance, fieldInstance);
                    } catch (IllegalAccessException e){
                        throw new RuntimeException(e);
                    }
                });
        return instance;
    }

    public static void doMethod(Object object, String methodName) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = object.getClass().getDeclaredMethods();

        Method targetMethod = null;
        List<Method> beforeMethod = new ArrayList<>();

        for (Method m : methods) {
            if(m.getName().equals(methodName)){
                targetMethod = m;
            }
            if(m.isAnnotationPresent(Before.class)){
                m.setAccessible(true);
                beforeMethod.add(m);
            }
        }

        beforeMethod.forEach(method -> {
            try {
                method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        assert targetMethod != null;
        targetMethod.invoke(object);
    }





}
