package seonjiwon.springstudy.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seonjiwon.springstudy.entity.Member;
import seonjiwon.springstudy.repository.MemberRepository;

@Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/member")
    public ResponseEntity<List<Member>> list() {
        List<Member> members = memberRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(members);
    }
}
