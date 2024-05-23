package org.sopt.kakaopay.service;

import jakarta.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.kakaopay.domain.Bookmark;
import org.sopt.kakaopay.domain.Member;
import org.sopt.kakaopay.exception.BusinessException;
import org.sopt.kakaopay.exception.ConflictException;
import org.sopt.kakaopay.repository.BookmarkRepository;
import org.sopt.kakaopay.service.dto.BookmarkAddDto;
import org.sopt.kakaopay.common.dto.ErrorMessage;
import org.sopt.kakaopay.exception.NotFoundException;
import org.sopt.kakaopay.service.dto.BookmarkDeleteDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final MemberService memberService;

    public Boolean existsBySourceMemberAndTargetMember(Member sourceMember, Member targetMember){
        return bookmarkRepository.existsBySourceMemberAndTargetMember(sourceMember, targetMember);
    }

    @Transactional
    public void AddBookmark(Long memberId, BookmarkAddDto bookmarkAddDto) {
        Member sourceMember = memberService.findMemberById(memberId);
        Member targetMember = memberService.findMemberByBankAndBankAccount(bookmarkAddDto.bank(),
            bookmarkAddDto.bankAccount());
        if (existsBySourceMemberAndTargetMember(sourceMember, targetMember)){
            throw new ConflictException(ErrorMessage.BOOKMARK_ALREADY_EXISTS);
        }
        Bookmark bookmark = new Bookmark(sourceMember, targetMember);

        bookmarkRepository.save(bookmark);

    }

    public void deleteBookmark(Long memberId, BookmarkDeleteDto bookmarkDeleteDto) {
        Member sourceMember = memberService.findMemberById(memberId);
        Member targetMember = memberService.findMemberByBankAndBankAccount(bookmarkDeleteDto.bank(),
                bookmarkDeleteDto.bankAccount());
        List<Bookmark> bookmarks = bookmarkRepository.findAllBySourceMemberAndTargetMember(sourceMember, targetMember);
        for (Bookmark bookmark : bookmarks) {
            bookmarkRepository.delete(bookmark);
        }
    }
}

