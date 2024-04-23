package org.example.kopring.controller

import org.example.kopring.entity.User
import org.example.kopring.query.user.UserQuery
import org.example.kopring.query.user.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(val userQuery: UserQuery) {

    private val logger = LoggerFactory.getLogger(UserController::class.java)


    @GetMapping("/{id}")
    fun test(@PathVariable("id") id: Long): User? {
        logger.info("find User Id: $id")
        return userQuery.findById(id)
    }
}