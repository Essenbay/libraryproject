package kz.fullstacklibrary.libraryproject.services

import kz.fullstacklibrary.libraryproject.data.modules.*
import kz.fullstacklibrary.libraryproject.data.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class BorrowedBookService @Autowired constructor(private val borrowedBookRepository: BorrowedBookRepository) {

    @Transactional(readOnly = true)
    fun getAllBorrowedBooks(): List<BorrowedBook> {
        return borrowedBookRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getBorrowedBookById(id: Long): Optional<BorrowedBook> {
        return borrowedBookRepository.findById(id)
    }

    @Transactional
    fun saveBorrowedBook(borrowedBook: BorrowedBook): BorrowedBook {
        return borrowedBookRepository.save(borrowedBook)
    }
}