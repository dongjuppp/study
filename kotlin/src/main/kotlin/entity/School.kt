package org.example.entity

data class School(
    val name: String,
    val address: Address,
    var students: MutableList<Student>
) {

    fun numberOfStudents() = students.size

    fun addStudent(student: Student) {
        validateStudent(student)
        students.add(student)
    }

    private fun validateStudent(student: Student) {
        if(!this.address.isAroundAddress(student.address)) {
            throw IllegalArgumentException("${student.name} is not ${this.address.city} Student")
        }
    }
}
