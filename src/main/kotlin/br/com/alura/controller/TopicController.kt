package br.com.alura.controller

import br.com.alura.model.Course
import br.com.alura.model.Topic
import br.com.alura.model.User
import br.com.alura.service.TopicService
import org.apache.juli.logging.Log
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("topics")
class TopicController(
    val service: TopicService
) {

    @GetMapping
    fun list(): List<Topic> {
        return service.getList()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Topic {
        return service.getById(id)
    }
}
