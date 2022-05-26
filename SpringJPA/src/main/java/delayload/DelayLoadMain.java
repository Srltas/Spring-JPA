package delayload;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DelayLoadMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            MemberV5 member = new MemberV5();
            member.setUsername("member");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            MemberV5 m = em.find(MemberV5.class, member.getId());

            System.out.println("m = " + m.getTeam().getClass());

            System.out.println("===============");
            System.out.println("TeamName = " + m.getTeam().getName());
            System.out.println("===============");

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
