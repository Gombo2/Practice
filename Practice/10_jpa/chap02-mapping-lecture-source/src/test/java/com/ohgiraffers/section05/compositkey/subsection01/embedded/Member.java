package com.ohgiraffers.section05.compositkey.subsection01.embedded;

import jakarta.persistence.*;

@Entity(name ="member_section05_subsection01")
@Table(name="tbl_member_section05_subsection01")
public class Member {
    /* 궁금. JPA는 객체단위로 인식하기때문에 인지시켜줘야함. 따로.
    *   복합키를 하나의 타입으로 정의내리도록 되어있음. int형과 string형 속성이 다른 두개라 두개를 MemberPK로 묶은것이다. */

    @EmbeddedId
    private MemberPK memberPK;
//    private String phone;
//    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;


    public Member() {
    }

    public Member(MemberPK memberPK, String phone, String address) {
        this.memberPK = memberPK;
        this.phone = phone;
        this.address = address;
    }

    public MemberPK getMemberPK() {
        return memberPK;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setMemberPK(MemberPK memberPK) {
        this.memberPK = memberPK;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberPK=" + memberPK +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
