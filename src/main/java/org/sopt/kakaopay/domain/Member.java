package org.sopt.kakaopay.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userId;

    private String name;

    private String payMoney;

    private String payPoint;

    private String bank;

    private String bankAccount;

    private String balance;

    public Member(String userId, String name, String payMoney, String payPoint, String bank, String bankAccount, String balance) {
        this.userId = userId;
        this.name = name;
        this.payMoney = payMoney;
        this.payPoint = payPoint;
        this.bank = bank;
        this.bankAccount = bankAccount;
        this.balance = balance;
    }

    public static Member create(String userId, String name, String payMoney, String payPoint, String bank, String bankAccount, String balance) {
        return new Member(userId, name, payMoney, payPoint, bank, bankAccount, balance);
    }
}
