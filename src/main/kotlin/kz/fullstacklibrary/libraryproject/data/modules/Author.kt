package kz.fullstacklibrary.libraryproject.data.modules

import jakarta.persistence.*

@Entity
@Table(name = "Authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val authorId: Long,

    @Column(nullable = false)
    val fullName: String,

    @ManyToMany(mappedBy = "authors")
    val bookRespons: Set<Book> = emptySet()
)
