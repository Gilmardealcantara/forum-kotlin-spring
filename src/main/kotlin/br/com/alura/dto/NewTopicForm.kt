package br.com.alura.dto

class NewTopicForm(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long
)
