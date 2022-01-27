package com.koko.introduction;

import com.koko.introduction.Repositories.JpaMemberRepository;
import com.koko.introduction.Repositories.MemberRepository;
import com.koko.introduction.Repositories.MemoryMemberRepository;
import com.koko.introduction.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Configuration
public class Config {
    private EntityManager em;

    @Autowired
    public Config(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(this.em);
    }


}
