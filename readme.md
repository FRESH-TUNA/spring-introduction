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