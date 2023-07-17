package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    // enum 타입은 @Enumerated 필요
    // EnumType.ORDINAL: 숫자로 저장됨. 따라서 중간에 새로운 값이 들어가면 꼬이게 됨
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY, COMP

}
