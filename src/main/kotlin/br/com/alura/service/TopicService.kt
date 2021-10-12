package br.com.alura.service

import br.com.alura.dto.NewTopicForm
import br.com.alura.dto.TopicView
import br.com.alura.dto.UpdateTopicForm
import br.com.alura.exception.NotFoundException
import br.com.alura.mapper.TopicFormMapper
import br.com.alura.mapper.TopicViewMapper
import br.com.alura.model.Topic
import br.com.alura.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {
    private val notFoundExceptionMessage = "Topic not found"
    fun getList(page: Pageable): Page<TopicView> {
        return repository.findAll(page).map { topicViewMapper.map(it) }
    }

    fun getById(id: Long): TopicView {
        val topic = repository.findById(id).orElseThrow { NotFoundException(notFoundExceptionMessage) }
        return topicViewMapper.map(topic)
    }

    fun save(form: NewTopicForm): TopicView {
        val newTopic = topicFormMapper.map(form)
        repository.save(newTopic)
        return topicViewMapper.map(newTopic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic = repository.findById(form.id).orElseThrow { NotFoundException(notFoundExceptionMessage) }
        val updatedTopic = topic.copy(title = form.title, message = form.message)
        repository.save(updatedTopic)
        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}
