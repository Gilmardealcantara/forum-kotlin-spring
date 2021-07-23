package br.com.alura.controller

import br.com.alura.model.Course
import br.com.alura.model.Topic
import br.com.alura.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("topics")
class TopicController {

    @GetMapping
    fun list(): List<Topic> {
        val topic = Topic(
            id = 1,
            title = "Kotlin Duvida",
            message = "Variable in kotlin lang",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "programing"
            ),
            author = User(
                id = 1,
                name = "Maria 22",
                email = "maria22@email.com"
            )
        )
        return listOf(topic, topic, topic)
    }
}
