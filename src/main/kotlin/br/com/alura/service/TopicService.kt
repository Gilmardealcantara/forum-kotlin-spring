package br.com.alura.service

import br.com.alura.model.Course
import br.com.alura.model.Topic
import br.com.alura.model.User
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class TopicService {
    private val topics: List<Topic>

    init {
        val topic1 = Topic(
            id = 1,
            title = "Kotlin Duvida 1",
            message = "Variable in kotlin lang 1",
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
        val topic2 = Topic(
            id = 2,
            title = "Kotlin Duvida 2",
            message = "Variable in kotlin lang 2",
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
        val topic3 = Topic(
            id = 3,
            title = "Kotlin Duvida 3",
            message = "Variable in kotlin lang 3",
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
        topics = listOf(topic1, topic2, topic3)
    }

    fun getList(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.find { it.id == id } ?: throw IllegalArgumentException("Id not found")
    }
}
