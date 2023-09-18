package kz.fullstacklibrary.libraryproject.services

import kz.fullstacklibrary.libraryproject.data.modules.Genre
import kz.fullstacklibrary.libraryproject.data.repositories.GenreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class GenreService @Autowired constructor(private val genreRepository: GenreRepository) {

    @Transactional(readOnly = true)
    fun getAllGenres(): List<Genre> {
        return genreRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getGenreById(id: Long): Optional<Genre> {
        return genreRepository.findById(id)
    }

    @Transactional
    fun saveGenre(genre: Genre): Genre {
        return genreRepository.save(genre)
    }

    @Transactional
    fun deleteGenreById(id: Long) {
        genreRepository.deleteById(id)
    }
}