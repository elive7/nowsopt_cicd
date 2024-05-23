package org.sopt.kakaopay.data.initializer;

import org.sopt.kakaopay.domain.Bookmark;
import org.sopt.kakaopay.domain.Member;
import org.sopt.kakaopay.repository.BookmarkRepository;
import org.sopt.kakaopay.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class BookmarkDataInitializer implements ApplicationRunner {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        if (memberRepository.findById(1L).isPresent() && memberRepository.findById(4L).isPresent() && memberRepository.findById(5L).isPresent()) {
            Member member1 = memberRepository.findById(1L).get();
            Member member4 = memberRepository.findById(4L).get();
            Member member5 = memberRepository.findById(5L).get();

            Bookmark[] bookmarks = new Bookmark[]{
                    Bookmark.create(member1, member4),
                    Bookmark.create(member1, member5)
            };

            Member[] sourceMembers = new Member[] {
                    member1,
                    member1
            };

            Member[] targetMembers = new Member[] {
                    member4,
                    member5
            };
            for (int i = 0; i< bookmarks.length; i++){
                if (!bookmarkRepository.findBySourceMemberAndTargetMember(sourceMembers[i], targetMembers[i]).isPresent()){
                    bookmarkRepository.save(bookmarks[i]);
                }
            }
        }

    }
}
