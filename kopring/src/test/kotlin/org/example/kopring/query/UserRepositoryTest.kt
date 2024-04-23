package org.example.kopring.query

import com.querydsl.jpa.impl.JPAQueryFactory
import org.example.kopring.entity.Gender
import org.example.kopring.entity.User
import org.example.kopring.query.user.UserQuery
import org.example.kopring.query.user.UserRepository
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = ["classpath:schema.sql"])
class UserRepositoryTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val em: TestEntityManager
){
    private lateinit var jpaQueryFactory: JPAQueryFactory
    private lateinit var userQuery: UserQuery

    @BeforeEach
    fun init() {
        jpaQueryFactory = JPAQueryFactory(em.entityManager)
        userQuery = UserQuery(jpaQueryFactory, userRepository)
    }

    @Test
    fun saveTest() {
        val newUser = User("TEST", Gender.MALE, "President")

        val savedUser = userQuery.save(newUser)

        assert(savedUser.id != null)
    }

    @Test
    fun findByIdTest() {
        val expectOne = userQuery.findById(1)

        assert("Danvers" == expectOne?.name)
    }

}