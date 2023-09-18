package kz.fullstacklibrary.libraryproject.data.repositories

import kz.fullstacklibrary.libraryproject.data.modules.Session
import org.springframework.data.jpa.repository.JpaRepository

interface SessionRepository : JpaRepository<Session, Long>
