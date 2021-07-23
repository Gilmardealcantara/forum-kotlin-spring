package br.com.alura.model

import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NO_ANSWERED,
    val responses: List<TopicResponse> = ArrayList()
)
