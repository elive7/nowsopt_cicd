package org.sopt.kakaopay.data.initializer;

import org.sopt.kakaopay.domain.Member;
import org.sopt.kakaopay.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MemberDataInitializer implements ApplicationRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Member[] members = new Member[] {
                Member.create("user1", "박수빈", "5,000", "15,000","신한", "110123456789", "20,007,500"),
                Member.create("user2", "양대한", "8,000", "10,000","카카오뱅크", "000123456789", "30,047,500"),
                Member.create("user3", "김도훈", "15,000", "30,000","카카오뱅크", "3333054449335", "50,000,500"),
                Member.create("user4", "박세은", "7,000", "17,000","토스뱅크", "100033074221", "88,008,800"),
                Member.create("user5", "이가인", "122,000", "35,000","신한", "1105122302069", "77,007,700")
        };
        for (int i = 0; i< members.length; i++){
            if (!memberRepository.findById(Long.valueOf(i+1)).isPresent()){
                memberRepository.save(members[i]);
            }
        }
    }
}
