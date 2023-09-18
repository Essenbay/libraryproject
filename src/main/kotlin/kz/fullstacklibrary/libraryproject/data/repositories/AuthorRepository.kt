package kz.fullstacklibrary.libraryproject.data.repositories

import kz.fullstacklibrary.libraryproject.data.modules.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long>
