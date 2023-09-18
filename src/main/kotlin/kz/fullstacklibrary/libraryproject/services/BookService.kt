package kz.fullstacklibrary.libraryproject.services

import kz.fullstacklibrary.libraryproject.data.modules.Book
import kz.fullstacklibrary.libraryproject.data.repositories.AuthorRepository
import kz.fullstacklibrary.libraryproject.data.repositories.BookRepository
import kz.fullstacklibrary.libraryproject.data.repositories.GenreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BookService @Autowired constructor(private val bookRepository: BookRepository, private  val authorRepository: AuthorRepository, private val genreRepository: GenreRepository) {

    @Transactional(readOnly = true)
    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getBookById(id: Long): Optional<Book> {
        return bookRepository.findById(id)
    }

    @Transactional
    fun saveBook(book: Book): Book {
        return bookRepository.save(book)
    }


    @Transactional
    fun deleteBookById(id: Long) {
        bookRepository.deleteById(id)
    }
}