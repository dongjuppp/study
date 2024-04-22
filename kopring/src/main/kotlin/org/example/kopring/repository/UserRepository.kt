package org.example.kopring.repository

import org.example.kopring.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long> {

    override fun findById(id: Long): Optional<User>
}