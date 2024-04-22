package org.example.kopring.controller

import org.example.kopring.entity.User
import org.example.kopring.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/user")
class UserController(val repository: UserRepository) {

    private val logger = LoggerFactory.getLogger(UserController::class.java)


    @GetMapping("/{id}")
    fun test(@PathVariable("id") id: Long): Optional<User> {
        logger.info("find User Id: $id")
        return repository.findById(id)
    }
}