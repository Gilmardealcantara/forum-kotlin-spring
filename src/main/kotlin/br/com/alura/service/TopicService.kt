package br.com.alura.service

import br.com.alura.dto.NewTopicForm
import br.com.alura.dto.TopicView
import br.com.alura.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val courseService: CourseService,
    private val userService: UserService
) {
    private val topics: MutableList<Topic> = mutableListOf()

    fun getList(): List<TopicView> {
        return topics.map {
            TopicView(
                id = it.id,
                title = it.title,
                message = it.message,
                status = it.status,
                createdAt = it.createdAt
            )
        }
    }

    fun getById(id: Long): TopicView {
        return topics.find { it.id == id }?.let {
            TopicView(
                id = it.id,
                title = it.title,
                message = it.message,
                status = it.status,
                createdAt = it.createdAt
            )
        } ?: throw IllegalArgumentException("Id not found")
    }

    fun save(form: NewTopicForm) {
        topics.add(
            Topic(
                id = (topics.size + 1).toLong(),
                title = form.title,
                message = form.message,
                course = courseService.getById(form.courseId),
                author = userService.getById(form.authorId)
            )
        )
    }
}
