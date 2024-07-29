package com.example;

import com.example.discount.DiscountPolicy;
import com.example.discount.FixDiscountPolicy;
import com.example.discount.RateDiscountPolicy;
import com.example.member.MemberRepository;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.member.MemoryMemberRepository;
import com.example.order.OrderService;
import com.example.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정정보
public class AppConfig {

    @Bean //스프링컨테이너에 등록됨
    public MemberService memberService(){
        return new MemberServiceImpl(memberReository()); //생성자 주입
    }
    @Bean
    public MemberRepository memberReository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberReository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }
}
