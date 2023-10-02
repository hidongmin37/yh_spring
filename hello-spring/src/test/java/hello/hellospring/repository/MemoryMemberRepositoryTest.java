package hello.hellospring.repository;


// test는 public으로 하지않아도 됨. 다른 곳에서 가져다 쓸 것이 아니기 때문

import hello.hellospring.domain.Member;
import hello.hellospring.respository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {
     MemoryMemberRepository repository = new MemoryMemberRepository();
     @AfterEach
     public void afterEach(){
            repository.clearStore(); //저장해두었던 것들 지우기 ,하나의 테스트가 끝날때마다 뭔가 저장소나 공용 데이터들을 다시 지워줘야함.
     }
     @Test
    public void save(){
         Member member = new Member();
         member.setName("spring");
         repository.save(member);
         Member result = repository.findById(member.getId()).get();
//         System.out.println("result =" + (result == member));
//         Assertions.assertEquals(member,result);
//         org.junit.jupiter.api.Assertions.assertEquals(member,null);
//         Assertions.assertThat(member).isEqualTo(result);//org.assertj.core.api.Assertions;
         assertThat(member).isEqualTo(result);
     }

     @Test
    public void findByName(){
         Member member1 = new Member();
         member1.setName("spring1");
         repository.save(member1);

         Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         repository.findByName("spring1");

         Member result = repository.findByName("spring2").get();
         assertThat(result).isEqualTo(member2);
     }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
