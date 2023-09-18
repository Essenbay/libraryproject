package kz.fullstacklibrary.libraryproject.services

import kz.fullstacklibrary.libraryproject.data.modules.Member
import kz.fullstacklibrary.libraryproject.data.repositories.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class MemberService @Autowired constructor(private val memberRepository: MemberRepository) {

    @Transactional(readOnly = true)
    fun getAllMembers(): List<Member> {
        return memberRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getMemberById(id: Long): Optional<Member> {
        return memberRepository.findById(id)
    }

    @Transactional
    fun saveMember(member: Member): Member {
        return memberRepository.save(member)
    }

    @Transactional
    fun deleteMemberById(id: Long) {
        memberRepository.deleteById(id)
    }
}