package com.example.order;

import com.example.discount.DiscountPolicy;
import com.example.discount.FixDiscountPolicy;
import com.example.member.Member;
import com.example.member.MemberRepository;
import com.example.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //grade만 넘길지, member 자체를 넘길지는 상황에 따라 달라짐

        return new Order(memberId,itemName,itemPrice, discountPrice);
    }
}
