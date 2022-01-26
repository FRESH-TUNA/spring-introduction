package com.koko.introduction;

import com.koko.introduction.Repositories.MemberRepository;
import com.koko.introduction.Repositories.MemoryMemberRepository;
import com.koko.introduction.Services.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
