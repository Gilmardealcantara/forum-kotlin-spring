package br.com.alura.mapper

import br.com.alura.dto.TopicView
import br.com.alura.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            createdAt = t.createdAt
        )
    }
}
