package com.example.discount;

import com.example.member.Grade;
import com.example.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    
    @Test
    @DisplayName("VIP는 10%할인이 적용된다.")
    void vip_o(){
        Member member =  new Member(1L, "memberVIP", Grade.VIP);
        
        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP는 아니면 할인이 안되어야 한다.")
    void vip_x(){
        Member member =  new Member(1L, "memberBasic", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }


}