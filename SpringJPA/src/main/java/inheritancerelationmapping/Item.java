package inheritancerelationmapping;

import javax.persistence.*;

//@Entity
@Inheritance(strategy = InheritanceType.JOINED) //조인 전략으로 테이블 생성
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일 테이블 전략으로 테이블 생성
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //구현 클래스마다 테이블 전략으로 테이블 생성
@DiscriminatorColumn //(DTYPE)단일 테이블 전략을 사용 시 기본적으로 추가됨, 구현 클래스마다 테이블에서는 Item 테이블이 생성되지 않아 의미가 없음
public abstract class Item extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
