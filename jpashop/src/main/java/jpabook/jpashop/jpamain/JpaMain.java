package jpabook.jpashop.jpamain;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jpabook.jpashop.domain.Member;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> cq = cb.createQuery(Member.class);
            Root<Member> m = cq.from(Member.class);
            CriteriaQuery<Member> where = cq.select(m).where(cb.equal(m.get("name"), "kim"));
            em.createQuery(where).getResultList();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
