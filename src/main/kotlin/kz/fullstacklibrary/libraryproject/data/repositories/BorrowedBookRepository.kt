package kz.fullstacklibrary.libraryproject.data.repositories

import kz.fullstacklibrary.libraryproject.data.modules.BorrowedBook
import org.springframework.data.jpa.repository.JpaRepository

interface BorrowedBookRepository : JpaRepository<BorrowedBook, Long>
