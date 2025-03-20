package seonjiwon.springstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seonjiwon.springstudy.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
