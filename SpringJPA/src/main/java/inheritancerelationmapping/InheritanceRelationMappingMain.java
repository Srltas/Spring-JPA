package inheritancerelationmapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class InheritanceRelationMappingMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 기본 전략 패턴은 한 테이블에 다 컬럼을 넣어버리는 것!
        try {
            Movie movie = new Movie();
            movie.setDirector("AAAA");
            movie.setActor("BBBB");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            movie.setCreatedDate(LocalDateTime.now());
            movie.setCreatedBy("Kim");

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);


            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
