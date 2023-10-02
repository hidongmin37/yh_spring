package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.respository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//@Service // 서비스라고 인식하고 스프링 컨테이너의 멤버서비스가 등록이 됨.
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired// 같은 db를 사용하게 하려면 이렇게 해서 공유를 하게끔 함.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        // 같은 이름이 있는 중복회원은 안된다.
//        Optional<Member> result = memberRepository.findByName(member.getName());
        validateDuplicateMember(member);
//        result.ifPresent(member1 -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//    });
        // ifPresent는 null이 아니라 어떤 값이 있으면,로직이 동작하는 것.
        // optional이기 때문에 가능한 것.

        memberRepository.save(member);
        return member.getId();
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }
}
