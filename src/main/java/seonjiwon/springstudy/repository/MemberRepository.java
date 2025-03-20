package seonjiwon.springstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seonjiwon.springstudy.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
