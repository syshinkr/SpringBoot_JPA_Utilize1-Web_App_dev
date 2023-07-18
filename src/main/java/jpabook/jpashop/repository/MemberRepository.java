package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // @PersistenceContext
    // Spring Data JPA 가 @AutoWired 로 치환을 지원해준다
    // @AutoWired 는 생성자가 하나뿐이면 선언하지 않아도 적용된다
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        // SQL : 테이블에 쿼리
        // JPQL: 엔티티 객체에 쿼리
        // "SELECT m FROM Member m": Member 객체 alias 로 m 선언 후, m 조회
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
