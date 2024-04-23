package org.example.kopring.query.user

import com.querydsl.jpa.impl.JPAQueryFactory
import org.example.kopring.entity.QUser
import org.example.kopring.entity.QUser.user
import org.example.kopring.entity.User
import org.springframework.stereotype.Repository

@Repository
class UserQuery(val jpaQueryFactory: JPAQueryFactory,
    val userRepository: UserRepository) {

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun findById(id: Long): User? {
        return jpaQueryFactory.selectFrom(user)
            .where(user.id.eq(id))
            .fetchOne()
    }
}