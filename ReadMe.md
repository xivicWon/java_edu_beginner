# Java Spring for Beginner 
--- 
( educated by inflearn )

## date : 22.02.13
- 개발툴 
   1. intelij
- 라이브러리
   - thymeleaf
   - spring-webmvc
   - spring-boot-starter
      1. spring-boot
      2. spring-boot-starter-logging
         1. logback, slf4j
   - spring-boot-starter-test
      1. junit : 테스트 프레임워크
      2. mockito : 목 라이브러리
      3. assertj : 테스트 코드를 좀 더 편하게 작성.
      4. spring-test : 스프링 통합 테스트 지원
- 기본적인 Thymeleaf 의 템플릿 객체 사용방법
  1. contoller 생성 . ( 만약 정상으로 인식 안될경우 Revert file Type override 로 java class 로 인식해야함.)
  2. hello 함수에서 반환되는 텍스트는 templates 에 파일명과 같아야 함. (hello)
  3. /src/main/resources/templates 에 파일 생성
  4. 매칭될 데이터 연동

- 실행 파일 만들기.
  - project structure 에서 Artifacts 로 jar빌더파일 생성.
  - File > Project Structure > Artifacts > + > JAR > From modules with dependencies...
  - META-INF 의 경로는 resources 하위로 변경후 저장.
  - Build > Build Artifacts... 선택
  - 자신이 만든 jar파일로 build 
  - 하지만 !! "기본 Manifest 속성이 없습니다" 발생... (포기)

- 정적 페이지 (static page)
  - /reousrces/static 아래 생성된 html 은 바로 접근이 가능.
  - 내부적으로 설명은 안됨. 다만 tomcat 에서 자동으로 templates 에 없으면 static에서 참조하는것으로 예상됨

- @ResponseBody
  - 데이터를 고유형태로 반환할때 사용하는 방식
  - 객체를 반환시 json 방식으로 반환한다.
  - Convert 객체
    - 문자 : StringHttpMessageConverter
    - 객체 : MappingJackson2HttpMessageConverter
    - 그 외는 HttpMeesageConverter 가 기본으로 있음.
    - HTTP Accept 에서 정의한 설정값과 데이터 반환 타입과 비교해서 Convert 객체가 채택된다.
  
- 계층 구조
  - 컨트롤러 : 웹 mvc 컨트롤러 역할
  - 서비스 : 핵심 비지니스 로직 
  - 리포지토리 : 데이터베이스 접근, 객체 DB 를 저장 및 관리
  - 도메인 : 비지니스 모데인 객체 

- 간단한 프로젝트 개발
  - 어떤 DB 로 선택될지 모르기 때문에 repository에는 implement 객체를 생성하여 구성한다.
  - findById 함수에서 없는 값을 참조할 경우 에러를 방지하기 위해 Optional.ofNullable 로 씌워준다.
  - findByName 에선 모든 회원중에 filter 를 해줘야 한다.
  - 공유되는 변수일때는 ConcurrentHashmap 이 좋다.
  - sequence 는 동시성 문제를 고려해서 atomicLong을 쓴다.
  - 테스트는 서로 의존관계가 없게 작성되어야 한다.
  - @AfterEach 를 통해 매 테스트 마다 초기화 해주는 작업이 필요하다.