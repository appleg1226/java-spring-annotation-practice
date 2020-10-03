package methodReflection;

public class MethodManager {

    @Before
    private void beforeMethod(){
        System.out.println("do something before!!");
    }

    public void doMethod(){
        System.out.println("do my main logic!!");
    }

}
