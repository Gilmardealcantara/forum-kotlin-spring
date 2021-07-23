package br.com.alura.model

data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: String,
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NO_ANSWERED,
    val responses: List<TopicResponse> = ArrayList()
)
