package seonjiwon.springstudy;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import seonjiwon.springstudy.entity.Book;
import seonjiwon.springstudy.entity.Loan;
import seonjiwon.springstudy.entity.Member;
import seonjiwon.springstudy.repository.BookRepository;
import seonjiwon.springstudy.repository.LoanRepository;
import seonjiwon.springstudy.repository.MemberRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {

    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    @PostConstruct
    public void initData() {
        if (memberRepository.count() == 0) { // 기존 데이터가 없을 때만 실행
            System.out.println("🔥 기본 데이터를 추가합니다...");

            // 회원 데이터 추가
            Member member1 = new Member("김철수", "chulsoo@example.com");
            Member member2 = new Member("이영희", "younghee@example.com");
            Member member3 = new Member("박민준", "minjun@example.com");

            memberRepository.save(member1);
            memberRepository.save(member2);
            memberRepository.save(member3);

            // 책 데이터 추가
            Book book1 = new Book("Spring Boot in Action", "Craig Walls", 2023, "9781617297571");
            Book book2 = new Book("Effective Java", "Joshua Bloch", 2018, "9780134685991");
            Book book3 = new Book("Clean Code", "Robert C. Martin", 2008, "9780132350884");
            Book book4 = new Book("Refactoring", "Martin Fowler", 2019, "9780201485677");
            Book book5 = new Book("The Pragmatic Programmer", "Andy Hunt & Dave Thomas", 1999,
                "9780201616224");

            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
            bookRepository.save(book5);

            // 대출 데이터 추가
            Loan loan1 = new Loan(member1, book1, LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(2), null, 0);
            Loan loan2 = new Loan(member1, book2, LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(2), null, 1);
            Loan loan3 = new Loan(member2, book3, LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(2), null, 0);

            loanRepository.save(loan1);
            loanRepository.save(loan2);
            loanRepository.save(loan3);

            log.info("✅ 기본 데이터 추가 완료!");
        }
    }
}

