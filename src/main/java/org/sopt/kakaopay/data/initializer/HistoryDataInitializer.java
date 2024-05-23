package org.sopt.kakaopay.data.initializer;

import org.sopt.kakaopay.domain.History;
import org.sopt.kakaopay.domain.Member;
import org.sopt.kakaopay.repository.HistoryRepository;
import org.sopt.kakaopay.repository.MemberRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class HistoryDataInitializer implements ApplicationRunner {
    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (memberRepository.findById(1L).isPresent() && memberRepository.findById(2L).isPresent() && memberRepository.findById(3L).isPresent() && memberRepository.findById(4L).isPresent() && memberRepository.findById(5L).isPresent()) {
            Member member1 = memberRepository.findById(1L).get();
            Member member2 = memberRepository.findById(2L).get();
            Member member3 = memberRepository.findById(3L).get();
            Member member4 = memberRepository.findById(4L).get();
            Member member5 = memberRepository.findById(5L).get();
            History[] histories = new History[] {
                    History.create(member1, member2, "5,000"),
                    History.create(member5, member1, "15,000"),
                    History.create(member2, member1, "7,000"),
                    History.create(member1, member4, "53,000"),
                    History.create(member1, member5, "9,000"),
                    History.create(member4, member2, "95,000"),
                    History.create(member2, member5, "43,000"),
                    History.create(member3, member1, "2,000"),
                    History.create(member1, member3, "2,000"),
            };
            for (int i = 0; i< histories.length; i++){
                if (!historyRepository.findById(Long.valueOf(i+1)).isPresent()){
                    historyRepository.save(histories[i]);
                }
            }
        }
    }
}
