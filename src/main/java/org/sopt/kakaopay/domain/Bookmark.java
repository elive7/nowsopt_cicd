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
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member sourceMember;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member targetMember;

    public Bookmark(Member sourceMember, Member targetMember) {
        this.sourceMember = sourceMember;
        this.targetMember = targetMember;
    }

    public static Bookmark create(Member sourceMember, Member targetMember) {
        return new Bookmark(sourceMember,targetMember);
    }
}
