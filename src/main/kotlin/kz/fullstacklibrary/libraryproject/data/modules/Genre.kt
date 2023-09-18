package kz.fullstacklibrary.libraryproject.data.modules

import jakarta.persistence.*

@Entity
@Table(name = "Genres")
data class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val genreId: Long,

    @Column(nullable = false)
    val title: String,

    @ManyToMany(mappedBy = "genres")
    val bookRespons: Set<Book> = emptySet()
)
