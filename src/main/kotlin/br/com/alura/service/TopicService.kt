package br.com.alura.service

import br.com.alura.dto.NewTopicForm
import br.com.alura.dto.TopicView
import br.com.alura.dto.UpdateTopicForm
import br.com.alura.mapper.TopicFormMapper
import br.com.alura.mapper.TopicViewMapper
import br.com.alura.model.Topic
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {
    private val topics: MutableList<Topic> = mutableListOf()

    fun getList(): List<TopicView> {
        return topics.map { topicViewMapper.map(it) }
    }

    fun getById(id: Long): TopicView {
        return topics.find { it.id == id }?.let { topicViewMapper.map(it) }
            ?: throw IllegalArgumentException("Id not found")
    }

    fun save(form: NewTopicForm): TopicView {
        val newTopic = topicFormMapper.map(form).copy(id = topics.size.toLong() + 1)
        topics.add(newTopic)
        return topicViewMapper.map(newTopic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        topics.find { it.id == form.id }?.let {
            topics.remove(it)
            val updatedTopic = it.copy(title = form.title, message = form.message)
            topics.add(updatedTopic)
            return topicViewMapper.map(updatedTopic)
        } ?: throw IllegalArgumentException("Topic not found")
    }

    fun delete(id: Long) {
        topics.find { it.id == id }?.let { topics.remove(it) }
    }
}
