package org.sopt.kakaopay.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.LookAndFeel;
import lombok.RequiredArgsConstructor;
import org.sopt.kakaopay.domain.History;
import org.sopt.kakaopay.domain.Member;
import org.sopt.kakaopay.repository.BookmarkRepository;
import org.sopt.kakaopay.repository.HistoryRepository;
import org.sopt.kakaopay.service.dto.HistoryFindDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final BookmarkService bookmarkService;
    private final MemberService memberService;

    public List<HistoryFindDto> getHistories(Long memberId){
        Member sourceMember = memberService.findMemberById(memberId);
        List<History> histories = historyRepository.findAllBySenderOrReceiverOrderByCreatedAtDesc(sourceMember, sourceMember);

        Set<Member> uniqueMember = new LinkedHashSet<>();
        List<Boolean> bookmarks = new ArrayList<>();
/*
        sourceMember의 최신 거래 내역에서 겹치지 않는 3명의 상대방 필터링
 */
        for (History history : histories) {
            if (history.getSender() == sourceMember) {
                uniqueMember.add(history.getReceiver());
            }
            else if (history.getReceiver() == sourceMember) {
                uniqueMember.add(history.getSender());
            }
            if (uniqueMember.size() >= 3) {
                break;
            }
        }
/*
        3명의 상대방에 대한 북마크 여부 저장
 */

        for (Member targetMember : uniqueMember) {
            Boolean bookmark = bookmarkService.existsBySourceMemberAndTargetMember(sourceMember, targetMember);
            bookmarks.add(bookmark);
        }

        return HistoryFindDto.findAll(new ArrayList<>(uniqueMember), bookmarks);

    }

}
