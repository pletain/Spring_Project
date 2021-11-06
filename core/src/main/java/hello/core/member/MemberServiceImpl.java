package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")
    public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    
    @Autowired
    public MemberServiceImpl(MemberRepository memoryMemberRepository) {
        this.memberRepository = memoryMemberRepository;
	}

	@Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }

}