package org.sopt.kakaopay.service.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.sopt.kakaopay.domain.History;
import org.sopt.kakaopay.domain.Member;

public record HistoryFindDto (String bank, String bankAccount, String name, Boolean bookmark){
    public static HistoryFindDto of(Member member, Boolean bookmark){
        return new HistoryFindDto(member.getBank(), member.getBankAccount(), member.getName(), bookmark);
    }

    public static List<HistoryFindDto> findAll(List<Member> members, List<Boolean> bookmarks){
        List<HistoryFindDto> list  = IntStream.range(0, members.size())
                .mapToObj(i-> HistoryFindDto.of(members.get(i), bookmarks.get(i)))
                .collect(Collectors.toList());

        return list;
    }
}
