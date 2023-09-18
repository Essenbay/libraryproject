package kz.fullstacklibrary.libraryproject.data.modules

import jakarta.persistence.*

@Entity
@Table(name = "Members")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId: Long,

    @Column(nullable = false)
    val fullName: String,

    @Column(nullable = false)
    val phoneNumber: String
)