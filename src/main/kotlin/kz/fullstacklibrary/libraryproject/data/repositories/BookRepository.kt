package kz.fullstacklibrary.libraryproject.data.repositories

import kz.fullstacklibrary.libraryproject.data.modules.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>
