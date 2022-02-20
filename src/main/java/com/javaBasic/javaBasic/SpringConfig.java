package com.javaBasic.javaBasic;

import com.javaBasic.javaBasic.repository.MemberRepository;
import com.javaBasic.javaBasic.repository.MemoryMemberRepository;
import com.javaBasic.javaBasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
