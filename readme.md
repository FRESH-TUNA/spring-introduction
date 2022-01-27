# Spring Introduction

## 자료
김영한: 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근기술

## 라이브러리
gradle이 의존이 푤요한 라이브러리를 다땡겨온다. 
우리는 spring boot starter 를 땡기지만 관련된것들을 다땡겨와서
core까지 가져온것을 볼수 있다.

## 컨트롤러 리턴
컨트롤러에서 String을 반환하면 기본적으로 resources/template/<string>.html을 찾아 템플릿엔진을 랜더링한다.

## 정적 컨텐츠 제공
<이름>.<확장자> 로 요청하면 * 이름을 가진 컨트롤러를 찾아보고 없으면
static폴더에 같은 (<이름>.<확장자>) 을 가진 녀석이 있으면 반환

## @ResponseBody
return 되는 값이 body에 직접들어간다, API개발시 기본원리로 사용된다.
@Responsebody 가 붙어 있는 경우에는 컨트롤러 처리후 String converter(스트링의 경우), 
JSON renderer(객체의 경우 default, jackson)로 던져서 처리한다.
기존의 template rendering방식과 다르다.

## @Autowired, @Configuration
@Autowired를 통해 스프링이 필요한 빈을 주입할수 있다. 
이때 bean은 @Controller, @Service, @Component를 명시하여
스프링이 등록할수 있도록 해줘야 한다.

@Autowired 는 해당 Class가 스프링 빈으로 등록되어있어야 동작한다
```java
// 이때 MemberService 는 bean으로 등록되어있어야 한다.
@Autowired
public MemberController(MemberService memberService) {
    this.memberService = memberService;
}
```

```java
// 직접 Configuration을 설정하여 Bean으로 등록할수 있다.
@Configuration
public class Config {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
```

## 스프링에서의 value 주입
스프링에서 값을주입할때는 set메소드, 생성자, 필드 방식으로 할수 있다.

## @Transactional
스프링 테스트에 이 어노테이션이 있으면 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료후
롤백 한다. (물론 테스트가 아니면 commit까지 진행된다)

## @Entity
JPA에서 관리하는 테이블임을 명시하는 어노테이션

## Spring data jpa
Spring Jpa가 자동으로 interface를 implement하여 자동으로 등록해준다.

```java
//interface 에 다음 메소드를 추가하면 다음과 같이 자동으로 구현해준다.

/*
        select m from member m where m.name = ?
 */
Optional <Member> findByName(String name);
```
