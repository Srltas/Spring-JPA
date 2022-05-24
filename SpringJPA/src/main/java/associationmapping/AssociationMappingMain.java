package associationmapping;

import primarykeymapping.MemberV3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AssociationMappingMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            MemberV4 member = new MemberV4();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);


            //객체를 테이블에 맞추어 모델링 했을 경우
//            member.setTeamId(team.getId());

//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            em.flush();
            em.clear();

            //객체 지향 모델링을 했을 경우
            MemberV4 findMember = em.find(MemberV4.class, member.getId());
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());

            //양방향 연관관계 매핑을 위해 team에 list 추가
            List<MemberV4> members = findMember.getTeam().getMembers();

            for (MemberV4 m : members) {
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
