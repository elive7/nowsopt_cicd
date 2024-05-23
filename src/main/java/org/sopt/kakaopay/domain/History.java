package org.sopt.kakaopay.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class History extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member receiver;

    private String amount;

    public History(Member sender, Member receiver, String amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public static History create(Member sender, Member receiver, String amount) {
        return new History(sender,receiver,amount);
    }
}
