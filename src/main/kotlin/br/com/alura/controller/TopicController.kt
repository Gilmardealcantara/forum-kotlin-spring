package br.com.alura.controller

import br.com.alura.dto.NewTopicForm
import br.com.alura.dto.TopicView
import br.com.alura.dto.UpdateTopicForm
import br.com.alura.model.Topic
import br.com.alura.service.TopicService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("topics")
class TopicController(
    val service: TopicService
) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.getList()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicView {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid form: NewTopicForm) {
        service.save(form)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm) {
        service.update(form)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}
