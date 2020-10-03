package parameterReflection;

public class ParamService {
    public void paramTest(@MaxNum(10) Integer num1, @MaxNum(10) Integer num2){
        System.out.println(num1);
        System.out.println(num2);
    }
}
