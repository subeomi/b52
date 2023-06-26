package org.zerock.b52.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {
    // @PreAuthorize("pricipal.username == #boardDTO.writer") 로그인 해야 수정 가능함 
    @PreAuthorize("permitAll") // 여기 들어가는건 표현식. Intellij는 지원해준다
    @GetMapping("/signup")
    public void signup(){
        log.info("signup-----------");
    }

    @PreAuthorize("hasAnyRole('ADMIN')") // hasRole(ROLE_을 제외한 권한) 체크
    @GetMapping("/mypage")
    public void mypage(){
        log.info("mypage-----------");
    }

    @GetMapping("/signin")
        public void signin(){
        log.info("signin-----------");
    }

}
