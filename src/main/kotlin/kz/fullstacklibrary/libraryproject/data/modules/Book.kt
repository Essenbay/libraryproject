package kz.fullstacklibrary.libraryproject.data.modules


import jakarta.persistence.*

@Entity
@Table(name = "Books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bookId: Long = 0,

    @Column(nullable = false)
    var title: String = "",

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "BooksAuthors",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: Set<Author> = emptySet(),

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "BooksGenres",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    val genres: Set<Genre> = emptySet()
)


