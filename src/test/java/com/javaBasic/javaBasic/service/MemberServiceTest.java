package com.javaBasic.javaBasic.service;

import com.javaBasic.javaBasic.domain.Member;
import com.javaBasic.javaBasic.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach () {
        memberRepository =  new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("회원가입")
    void join() {
        //given
        Member member= new Member();
        member.setName("테스트");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    @DisplayName("중복회원예외")
    void except_duplicate_member(){

        //given
        Member member1= new Member();
        member1.setName("테스트");
        Member member2= new Member();
        member2.setName("테스트");

        //when
        memberService.join(member1);
//        try{
//            Long saveId2 = memberService.join(member2);
//            org.junit.jupiter.api.Assertions.fail();
//        } catch (IllegalStateException e ){
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class , ()->memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    @DisplayName("전체 회원조회")
    void findMembers() {
    }

    @Test
    @DisplayName("단일 회원조회")
    void findOne() {
    }
}