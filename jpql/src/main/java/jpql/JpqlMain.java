package jpql;

import jpql.entity.Member;
import jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpqlMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            for (int i = 0; i < 10; i++) {
                Member member = new Member();
                member.setUsername("member" + i);
                member.setAge(i);
                member.setTeam(team);

                em.persist(member);
            }

            em.flush();
            em.clear();

//            [이름 기준 파라미터 바인딩]
//            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();

//            [프로젝션 - DTO를 만들어서 조회]
//            List<MemberDTO> resultList = em.createQuery("select new jpql.entity.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = resultList.get(0);
//            System.out.println("username = " + memberDTO.getUsername());
//            System.out.println("age = " + memberDTO.getAge());

//            [페이징]
//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(10)
//                    .setMaxResults(20)
//                    .getResultList();
//
//            System.out.println("result.size() = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }

//            [조인]
//            String query = "select m from Member m inner join m.team t";
            String query = "select m from Member m left outer join m.team t";
//            String query = "select m from Member m, Team t where m.username = t.name";

            List<Member> result = em.createQuery(query, Member.class)
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
