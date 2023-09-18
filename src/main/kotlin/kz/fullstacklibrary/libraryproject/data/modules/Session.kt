package kz.fullstacklibrary.libraryproject.data.modules

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "Sessions")
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val sessionId: Long,

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    val member: Member,

    @Column(nullable = false)
    val entryDate: LocalDate,

    @Column
    val exitDate: LocalDate?
)