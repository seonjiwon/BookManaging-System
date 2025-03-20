package seonjiwon.springstudy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import seonjiwon.springstudy.entity.Member;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @DisplayName("저장 테스트")
    public void testMember() {
        Member member = new Member("user1", "temp@temp.com");
        Member savedMember = memberRepository.save(member);

        assertThat(savedMember).isEqualTo(member);
    }
}