# BookManaging-System
BookManaging System

## **📌 프로젝트 개요**
BookManaging-System은 책 대출 및 반납을 관리하는 간단한 시스템입니다.

---

## **📌 데이터베이스 테이블 구조**
| 테이블 | 컬럼 | 데이터 타입 | 제약 조건 | 설명 |
|--------|------|------------|----------|------|
| **member (회원)** | `id` | `BIGINT` | `PRIMARY KEY, AUTO_INCREMENT` | 회원 ID |
| | `name` | `VARCHAR(255)` | `NOT NULL` | 회원 이름 |
| | `email` | `VARCHAR(255)` | `UNIQUE, NOT NULL` | 회원 이메일 (중복 불가) |
| | `borrowed_books_count` | `INT` | `NOT NULL DEFAULT 0` | 현재 대출 중인 책 개수 (최대 3) |
| **book (책 정보)** | `id` | `BIGINT` | `PRIMARY KEY, AUTO_INCREMENT` | 책 ID |
| | `title` | `VARCHAR(255)` | `NOT NULL` | 책 제목 |
| | `author` | `VARCHAR(255)` | `NOT NULL` | 저자 |
| | `published_year` | `INT` | `NOT NULL` | 출판 연도 |
| | `isbn` | `VARCHAR(20)` | `UNIQUE, NOT NULL` | ISBN (중복 불가) |
| | `available` | `BOOLEAN` | `NOT NULL DEFAULT TRUE` | 대출 가능 여부 |
| **loan (대출 정보)** | `id` | `BIGINT` | `PRIMARY KEY, AUTO_INCREMENT` | 대출 ID |
| | `book_id` | `BIGINT` | `FOREIGN KEY REFERENCES book(id)` | 대출한 책 ID |
| | `member_id` | `BIGINT` | `FOREIGN KEY REFERENCES member(id)` | 대출한 회원 ID |
| | `loan_date` | `TIMESTAMP` | `DEFAULT CURRENT_TIMESTAMP` | 대출 날짜 |
| | `due_date` | `TIMESTAMP` | `NOT NULL` | 반납 기한 (대출 후 2주) |
| | `return_date` | `TIMESTAMP` | `NULL` | 반납한 날짜 (NULL이면 미반납) |
| | `extension_count` | `INT` | `NOT NULL DEFAULT 0` | 연장 횟수 (최대 3) |

---

## **📌 API 엔드포인트**
| 메서드 | 엔드포인트                     | 설명 |
|--------|--------------------------------|--------------------------------------------|
| **회원 API** |
| `GET` | `/api/members` | 모든 회원 목록 조회 |
| `POST` | `/api/members` | 새 회원 등록 |
| **책 API** |
| `GET` | `/api/books` | 모든 책 목록 조회 |
| `POST` | `/api/books` | 새 책 등록 |
| **대출 API** |
| `POST` | `/api/loans/{bookId}/borrow` | 특정 책 대출 (`memberId` 필요) |
| `PATCH` | `/api/loans/{loanId}/return` | 특정 대출 반납 |
| `PATCH` | `/api/loans/{loanId}/extend` | 특정 대출 1주 연장 (최대 3회) |
| `GET` | `/api/loans?memberId=1` | 특정 회원의 대출 목록 조회 |

이제 `README.md` 파일에서 프로젝트의 DB 상태와 엔드포인트 정보를 확인할 수 있습니다! 🚀
