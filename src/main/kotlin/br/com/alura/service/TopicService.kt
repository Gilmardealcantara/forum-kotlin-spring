package br.com.alura.service

import br.com.alura.model.Course
import br.com.alura.model.Topic
import br.com.alura.model.User
import org.springframework.stereotype.Service

@Service
class TopicService {
    fun getList(): List<Topic> {
        val topic = Topic(
            id = 1,
            title = "Kotlin Duvida 2",
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
