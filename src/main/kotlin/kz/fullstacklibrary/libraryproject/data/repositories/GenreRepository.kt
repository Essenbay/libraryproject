package kz.fullstacklibrary.libraryproject.data.repositories

import kz.fullstacklibrary.libraryproject.data.modules.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository : JpaRepository<Genre, Long>
