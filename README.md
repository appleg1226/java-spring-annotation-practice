# Reflection과 Annotation에 대한 프로젝트

## 1) @Target
### 이 어노테이션은 선언한 어노테이션이 적용될 수 있는 위치를 결정한다
가능한 ElementType의 목록
- TYPE : class, interface, enum에 적용된다. 
- FIELD : 클래스 필드 변수
- METHOD : 메서드
- PARAMETER : 메서드 인자
- CONSTRUCTOR : 생성자
- LOCAL_VARIABLE : 로컬 변수
- ANNOTATION_TYPE : 어노테이션 타입에만 적용된다
- PACKAGE : 패키지 
- TYPE_PARAMETER : 자바8부터 추가된 값으로 제네릭 타입 변수에 적용된다. (ex. MyClass<T>)
- TYPE_USE : 자바8부터 추가된 값으로 어떤 타입에도 적용된다 (ex. extends, implements, 객체 생성시등등)
- MODULE : 자바9부터 추가된 값으로 모듈에 적용된다

## 2) @Retention
### 어노테이션이 어느 레벨까지 유지되는지를 결정짓는다. 
RetentionPolicy Enum에 선언된 값 
- SOURCE : 자바 컴파일에 의해서 어노테이션은 삭제된다
- CLASS : 어노테이션은 .class 파일에 남아 있지만, runtime에는 제공되지 않는 어노테이션으로 Retention policy의 기본 값이다
- RUNTIME : runtime에도 어노테이션이 제공되어 자바 reflection으로 선언한 어노테이션에 접근할 수 있다. 주로 이걸 사용한다. 

## 3) @Inherited
이 어노테이션을 선언하면 자식클래스가 어노테이션을 상속 받는다

## 4) @Documented
이 어노테이션을 선언하면 새로 생성한 어노테이션이 자바 문서 생성시 자바 문서에도 포함시키는 어노테이션이다. 

## 5) @Repeatable
자바8에 추가된 어노테이션으로 반복 선언을 할 수 있게 해준다

참조) https://advenoh.tistory.com/21

## 직접 구현한 Annotation & Reflection
- fieldReflection 패키지: ElementType.Field를 구현. 스프링의 Autowired처럼 자동으로 클래스 주입을 구현했다.
- methodReflection 패키지: ElementType.Method를 구현.   
  Junit의 Before처럼 해당 클래스에 Before라는 어노테이션을 가진 메서드가 있을 경우, 먼저 실행할 수 있도록 하였다.
- parameterReflection 패키지: ElementType.Parameter를 구현.   
MaxNum(n) 을 파라미터에 넣고, n과 실제 input을 비교하여 더 큰 값을 가지고 메서드에서 요청을 실행하도록 하였음.
    
## 느낀 점
- 제대로 사용하려면 더더욱 Reflection을 잘 다루도록 삽질을 해야할 것 같다.
- Annotation은 내가 아니라 누군가가(프레임워크 등) 무엇을 하는지에 대한 것을 정의할 때 사용한다고 느꼈다.
- Spring에서 AutowiredAnnotationBeanPostProcessor.java를 봤다. Autowired 자체가 워낙 강력한 기능이라고는 하지만,  
  확실히 이렇게 많은 코드로 processing을 하고 있구나..라는 생각을 했다. 프레임워크 만드는 사람들은 정말 대단하다는 말밖엔 안 나온다.  
(https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/factory/annotation/AutowiredAnnotationBeanPostProcessor.java)
   