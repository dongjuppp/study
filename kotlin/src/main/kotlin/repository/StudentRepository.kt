package org.example.repository

import org.example.entity.Address
import org.example.entity.Student

class StudentRepository {

    fun addStudent(student: Student) {

    }
}

private object Students {
    val students = listOf(
        Student(id = 0, name = "Rooney", age = 13, grade = 1, Address(city = "서울")),
        Student(id = 1, name = "Messi", age = 15, grade = 3, Address(city = "부산")),
        Student(id = 2, name = "Suzy", age = 17, grade = 5, Address(city = "광주")),
        Student(id = 3, name = "Ronaldo", age = 13, grade = 1, Address(city = "마데이라"))
    )
}

