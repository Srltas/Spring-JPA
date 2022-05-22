package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainV1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //삽입 코드
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");

//            em.persist(member);

            //조회코드
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //삭제코드
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            //수정코드
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            //Member 객체를 대상으로 조회하는 것
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
