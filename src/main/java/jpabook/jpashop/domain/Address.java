package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // 내장타입;다른 엔티티가 가질 수 있는 타입
// @Embedded @Embeddable 둘 중 한 쪽에만 선언해도 되지만 보통 둘 다 씀
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    // 값 타입은 기본적으로 setter 비제공
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
