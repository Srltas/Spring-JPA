# Spring-JPA
김영한님의 JPA 프로그래밍 - 기본편 강의 학습 내용 정리 및 기록

# 22.05.22
 - 기존 SQL 중심적인 개발의 문제점, JPA 소개
 - JPA 설정, 실행 및 JPQL 학습
 - 영속성 컨텍스트 학습 (엔티티의 생명주기 - 비영속, 영속, 준영속, 삭제)
 - 영속성 컨텍스트의 이점 - 1차 캐시, 동일성 보장, 쓰기 지연, 변경 감지, 지연 로딩)

# 22.05.23
 - @Entity 속성 정리, DB 스키마 자동 생성 설정, 필드와 컬럼 매핑 어노테이션 학습
 - 기본 키 매핑 IDENTITY, SEQUENCE, TABLE 전략 특징 학습
 - 실제와 비슷한 예제를 통해 데이터 중심 엔티티 설계의 문제점 학습

# 22.05.24
 - 객체는 참조, 테이블은 외래 키로 조인해서 연관관계 매핑
 - 단방향 연관관계, 양방향 연관관계 학습 및 코드 작성

# 22.05.25
 - [N:1], [1:N], [1:1], [N:M] 연관관계 매핑 학습
 - 상속관계 매핑 (조인 전략, 단일 테이블 전략, 구현 클래스마다 테이블 생성 전략) 학습
 - @MappedSuperclass를 이용한 매핑 학습

# 22.05.26
 - 프록시를 이용한 조회(getReference()) 개념 학습
 - 지연로딩, 즉시로딩 학습
 - 영속성 전이(cascade), 고아객체 학습

# 22.05.27
 - 엔티티 타입과 값 타입 비교 학습
 - 임베디드 타입 (@Embeddable, @Embedded) 학습
 - 항상 값을 복사해서 사용해 값이 변경되면 참조하는 모든 객체의 값이 변경되는 객체 타입의 한계를 극복하기 위해서 불변 객체 등장
 - 불변 객체는 생성 시점 이후에 절대 값을 변경할 수 없음
 - 값 타입을 하나 이상 저장할 때 사용하는 값 타입 컬렉션 학습
 - 값 타입 컬렉션은 주인 엔티티와 연관된 모든 데이터를 삭제하고, 값 타입 컬렉션에 있는 현재 값을 모두 다시 저장하는 제약사항이 있음
 - 값 타입 컬렉션 대신에 일대다 관계의 엔티티를 만들어 주로 사용

# 22.05.28
 - JPQL, Criteria, QueryDSL, 네이티브 SQL 소개
 - JPQL 기본 문법(파라미터 바인딩, 프로젝션, 페이징 API, 조인, 서브쿼리) 학습

# 22.05.29
 - JPQL 경로 표현식(상태 필드, 단일 값 연관 경로, 컬렉션 값 연관 경로)
 - 단일 값 연관 경로, 컬렉션 값 연관 경로 : 묵시적 내부 조인 발생함으로 명시적 조인(join 키워드 직접 사용)
 - 페치 조인(fetch join) 연관된 엔티티나 컬렉션을 SQL 한 번에 함께 조회
 - 일대다 경우 페치 조인을 하면 중복된 데이터가 같이 조회되어 DISTINCT를 사용해 중복 제거
 - DISTINCT는 애플리케이션에서 같은 식별자를 가진 엔티티 중복도 제거 가능
 - 네임드 쿼리, 벌크 연산 예제 코드 학습
