package kz.fullstacklibrary.libraryproject.services

import kz.fullstacklibrary.libraryproject.data.modules.*
import kz.fullstacklibrary.libraryproject.data.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class SessionService @Autowired constructor(private val sessionRepository: SessionRepository) {

    @Transactional(readOnly = true)
    fun getAllSessions(): List<Session> {
        return sessionRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getSessionById(id: Long): Optional<Session> {
        return sessionRepository.findById(id)
    }

    @Transactional
    fun saveSession(session: Session): Session {
        return sessionRepository.save(session)
    }
}