package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue  // 자동 생성
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장타입 포함.
    private Address address;

    @OneToMany(mappedBy = "member") // Order 객체(orders 테이블)의 member 필드에 의해 맵핑됨
    // 관계주인이 아니므로 읽기 전용이 됨
    private List<Order> orders = new ArrayList<>();
}
