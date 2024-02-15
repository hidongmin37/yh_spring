package jpaBook.jpaShop2.domain.service;

import jpaBook.jpaShop2.domain.Member;
import jpaBook.jpaShop2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    //회원가입
    public Long join(Member member) {
        validateDuplicateMember(member); //중복회원 검증로직
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findByNameMembers = memberRepository.findByName(member.getName());
        if (!findByNameMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


}
