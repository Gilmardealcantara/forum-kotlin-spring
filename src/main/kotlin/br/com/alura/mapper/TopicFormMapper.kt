package br.com.alura.mapper

import br.com.alura.dto.NewTopicForm
import br.com.alura.model.Topic
import br.com.alura.service.CourseService
import br.com.alura.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic = Topic(
        title = t.title,
        message = t.message,
        course = courseService.getById(t.courseId),
        author = userService.getById(t.authorId)
    )
}
