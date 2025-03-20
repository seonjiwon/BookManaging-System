package seonjiwon.springstudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private int id;

    private String title;
    private String author;
    private int published_year;
    private String isbn;
    private boolean available;

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedBy
    private LocalDateTime updatedAt;

    public Book(String title, String author, int published_year, String isbn) {
        this.title = title;
        this.author = author;
        this.published_year = published_year;
        this.isbn = isbn;
        this.available = true;
    }
}
