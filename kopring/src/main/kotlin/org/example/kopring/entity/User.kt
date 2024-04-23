package org.example.kopring.entity

import jakarta.persistence.*
import lombok.Getter
import org.springframework.data.convert.EntityConverter

@Entity(name = "my_user")
class User(name: String, gender: Gender, job: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    val name: String = name

    @Convert(converter = GenderConverter::class)
    val gender: Gender = gender

    val job: String = job

}

enum class Gender(val value: String, val description: String) {
    MALE("M", "Male"),
    FEMALE("F", "Female"),
}

@Converter
class GenderConverter : AttributeConverter<Gender, String?> {
    override fun convertToDatabaseColumn(p0: Gender?): String? {
        return p0?.value ?: throw IllegalArgumentException("")
    }

    override fun convertToEntityAttribute(p0: String?): Gender {
        return Gender.values().firstOrNull{it.value == p0 } ?: throw IllegalArgumentException("")
    }

}