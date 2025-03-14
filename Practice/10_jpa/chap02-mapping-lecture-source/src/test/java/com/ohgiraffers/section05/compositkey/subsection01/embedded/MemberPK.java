package com.ohgiraffers.section05.compositkey.subsection01.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

/* 설명.
*   Embeddable 타입은 하나의 값의 묶음이자 불변 객체로 다루는 타입이다.
*   (불변 객체: setter가 없고 필드값에 변화가 생기면 새로운 객체를 생성해야 하는 객체)
*   그리고 equals/hashCode를 오버라이딩 해야 한다. == 동등하기만 해도 같다.
*   -> 객체 값이 같기만 해도 같다고 판단해주기 (주소값으로 다루고자 하는게 아님)
*   VO와 유사하며 @EmbeddedId로 복합키를 표현하고자 할 때 쓰기도 한다.
* */
@Embeddable
public class MemberPK {
    /* 궁금. 복합키의 타입을 만드는 예제용 클래스. */

    @Column(name="member_no")
    private int memberNo;

    @Column(name="member_id")
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberPK memberPK = (MemberPK) o;
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }
}
