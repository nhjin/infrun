package com.example;

import com.example.member.Grade;
import com.example.member.Member;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ///AppConfig appConfig = new AppConfig();
        ///MemberService memberService = appConfig.memberService(); //appconfig, memberserviceImpl
        //MemberService memberService = new MemberServiceImpl(); //순자적으로 돌듯이

        //스프링 컨테이너에서 가져옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //appconfig에 있는 환경설정을 가지고 @bean에 객체에서 생성해서 관리하기 시작함

        //이 객체를 찾을 거임
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
