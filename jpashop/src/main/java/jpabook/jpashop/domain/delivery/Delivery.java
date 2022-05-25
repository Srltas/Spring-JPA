package jpabook.jpashop.domain.delivery;

import jpabook.jpashop.domain.config.BaseEntity;
import jpabook.jpashop.domain.order.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    @OneToOne(mappedBy="delivery")
    private Order order;
}
