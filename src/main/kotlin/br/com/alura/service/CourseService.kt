package br.com.alura.service

import br.com.alura.model.Course
import br.com.alura.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(private val repository: CourseRepository) {
    fun getById(id: Long): Course = repository.getById(id)
}
