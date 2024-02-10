package jpabasic.hellojpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;

import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setName("member1");
            member.setAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=========== START ===========");
            Member findMember = em.find(Member.class, member.getId());

            // Lazy Loading
//            List<Address> addressHistory = findMember.getAddressHistory();
//            // Hibernate.initialize(addressHistory);
//            for (Address address : addressHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//            for (String favoriteFood : findMember.getFavoriteFoods()) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }
//
//
//            findMember.setAddress(new Address("newCity", findMember.getAddress().getStreet(), findMember.getAddress().getZipcode()));
//
//            // 치킨 --> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));
            System.out.println("=========== END ===========");



            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
