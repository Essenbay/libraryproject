package kz.fullstacklibrary.libraryproject.controllers

import kz.fullstacklibrary.libraryproject.data.modules.*
import kz.fullstacklibrary.libraryproject.services.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client")
class HomeController constructor(private val bookService: BookService, private  val genreService: GenreService) {
    @GetMapping("/books")
    fun getAllBooks(): List<Book> {
        return bookService.getAllBooks()
    }

    @GetMapping("/books/{id}")
    fun getBookById(@PathVariable id: Long): ResponseEntity<Book>  {
        return bookService.getBookById(id).map { book ->
            ResponseEntity.ok(book)
        }.orElse(ResponseEntity.notFound().build())    }
    @PostMapping("/books")
    fun createBook(@RequestBody book: Book) : ResponseEntity<Book> {
        bookService.saveBook(book)
        return ResponseEntity(book, HttpStatus.CREATED)
    }

    @PutMapping("/books/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody newBook: Book) : ResponseEntity<Book>   {
        val book = bookService.getBookById(id)
        return book.map {
            val updatedBook = it.copy(
                title = newBook.title,
                authors = newBook.authors,
                genres = newBook.genres
            )
             ResponseEntity.ok().body( bookService.saveBook(updatedBook))


        }.orElse( ResponseEntity.notFound().build())

    }

    @DeleteMapping("/books/{id}")
    fun deleteBook(@PathVariable id: Long) {
        bookService.deleteBookById(id)
    }

    @PostMapping("/genres")
    fun createGenre(@RequestBody genre: Genre) : ResponseEntity<Genre> {
        genreService.saveGenre(genre)
        return ResponseEntity(genre, HttpStatus.CREATED)
    }

}