package org.example

import org.example.entity.Address
import org.example.entity.School
import org.example.entity.Student

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val seoul = Address("서울")
    val busan = Address("부산")

    val hansungSchool = School(name = "한성고", address = seoul, students = arrayListOf())

    val jjang = Student(id = 1, name = "짱맨", age = 17, grade = 1, address = seoul)

    hansungSchool.addStudent(jjang)

    println("${hansungSchool.name}, 전교생 수: ${hansungSchool.numberOfStudents()}")
}