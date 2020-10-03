package fieldReflection;

public class FooManager {

    @Autowired
    private FooService fooService;

    public void doFoo(){
        fooService.foo();
    }
}
