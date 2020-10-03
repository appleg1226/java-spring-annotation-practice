package fieldReflection;

import container.ContainerService;

public class FooMain {
    public static void main(){
        FooManager defaultFoo = ContainerService.getObject(FooManager.class);
        defaultFoo.doFoo();
    }
}
