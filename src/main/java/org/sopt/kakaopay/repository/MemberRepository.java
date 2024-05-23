package org.sopt.kakaopay.repository;

import java.util.Optional;
import org.sopt.kakaopay.common.dto.ErrorMessage;
import org.sopt.kakaopay.domain.Member;
import org.sopt.kakaopay.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByBankAndBankAccount(String bank, String bankAccount);


    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
            () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }
}



