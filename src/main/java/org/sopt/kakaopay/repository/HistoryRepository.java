package org.sopt.kakaopay.repository;

import java.util.List;
import org.sopt.kakaopay.domain.History;
import org.sopt.kakaopay.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllBySenderOrReceiverOrderByCreatedAtDesc(Member sender, Member receiver);
}
