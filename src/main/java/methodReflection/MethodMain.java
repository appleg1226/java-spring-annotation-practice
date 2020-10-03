package methodReflection;

import container.ContainerService;

import java.lang.reflect.InvocationTargetException;

public class MethodMain {

    public static void main() throws InvocationTargetException, IllegalAccessException {
        MethodManager manager = new MethodManager();
        ContainerService.doMethod(manager, "doMethod");
    }

}
