package com.example;

import com.example.discount.FixDiscountPolicy;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.member.MemoryMemberRepository;
import com.example.order.OrderService;
import com.example.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
