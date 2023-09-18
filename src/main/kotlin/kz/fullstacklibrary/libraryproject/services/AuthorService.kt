package kz.fullstacklibrary.libraryproject.services

import kz.fullstacklibrary.libraryproject.data.modules.Author
import kz.fullstacklibrary.libraryproject.data.repositories.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthorService @Autowired constructor(private val authorRepository: AuthorRepository) {

    @Transactional(readOnly = true)
    fun getAllAuthors(): List<Author> {
        return authorRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getAuthorById(id: Long): Author? {
        return authorRepository.findById(id).orElse(null)
    }

    @Transactional
    fun saveAuthor(author: Author): Author {
        return authorRepository.save(author)
    }

    @Transactional
    fun deleteAuthorById(id: Long) {
        authorRepository.deleteById(id)
    }
}
