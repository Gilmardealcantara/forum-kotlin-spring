package br.com.alura.service

import br.com.alura.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService {
    private val courses: List<Course>

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "programing"
        )
        courses = listOf(course)
    }

    fun getById(id: Long): Course = courses.find { it.id == id } ?: throw IllegalArgumentException("Not found course with this id")
}
