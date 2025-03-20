package seonjiwon.springstudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Loan {

    @Id
    @GeneratedValue
    @Column(name = "loan_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private LocalDateTime loan_date;
    private LocalDateTime due_date;
    private LocalDateTime return_date;

    private int extension_count;

    public Loan(Member member, Book book, LocalDateTime loan_date, LocalDateTime due_date,
                LocalDateTime return_date, int extension_count) {
        this.member = member;
        this.book = book;
        this.loan_date = loan_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.extension_count = extension_count;
    }
}
