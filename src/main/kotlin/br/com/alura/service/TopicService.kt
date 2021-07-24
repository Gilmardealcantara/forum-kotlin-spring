package br.com.alura.service

import br.com.alura.dto.NewTopicForm
import br.com.alura.dto.TopicView
import br.com.alura.mapper.TopicFormMapper
import br.com.alura.mapper.TopicViewMapper
import br.com.alura.model.Topic
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

    fun save(form: NewTopicForm) {
        topics.add(topicFormMapper.map(form).copy(id = topics.size.toLong() + 1))
    }
}
