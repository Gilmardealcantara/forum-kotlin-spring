package br.com.alura.service

import br.com.alura.dto.NewTopicDto
import br.com.alura.model.Course
import br.com.alura.model.Topic
import br.com.alura.model.User
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val courseService: CourseService,
    private val userService: UserService
) {
    private val topics: MutableList<Topic> = mutableListOf()

    fun getList(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.find { it.id == id } ?: throw IllegalArgumentException("Id not found")
    }

    fun save(dto: NewTopicDto) {
        topics.add(
            Topic(
                id = (topics.size + 1).toLong(),
                title = dto.title,
                message = dto.message,
                course = courseService.getById(dto.courseId),
                author = userService.getById(dto.authorId)
            )
        )
    }
}
