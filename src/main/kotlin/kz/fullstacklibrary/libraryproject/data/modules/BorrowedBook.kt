package kz.fullstacklibrary.libraryproject.data.modules

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "BorrowedBooks")
data class BorrowedBook(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val borrowId: Long,

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    val member: Member,

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    val book: Book,

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "sessionId")
    val session: Session,

    @Column(nullable = false)
    val borrowTime: LocalDateTime,

    @Column
    val returnTime: LocalDateTime?
)