package org.sopt.kakaopay.repository;

import java.util.List;
import java.util.Optional;
import org.sopt.kakaopay.domain.Bookmark;
import org.sopt.kakaopay.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findAllBySourceMemberAndTargetMember(Member sourceMember, Member targetMember);

    Optional<Bookmark> findBySourceMemberAndTargetMember(Member sourceMember, Member targetMember);

    Boolean existsBySourceMemberAndTargetMember(Member sourceMember, Member targetMember);

}
