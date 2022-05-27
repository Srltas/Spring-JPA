package jpabook.jpashop.domain.delivery;

import jpabook.jpashop.domain.config.BaseEntity;
import jpabook.jpashop.domain.order.Order;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Embedded
    private Address address;
    private DeliveryStatus status;

    @OneToOne(mappedBy="delivery", fetch = FetchType.LAZY)
    private Order order;

    @Override
    public int hashCode() {
        return Objects.hash(id, address, status, order);
    }
}
