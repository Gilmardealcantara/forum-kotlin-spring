package br.com.alura.dto

import javax.validation.constraints.*

class NewTopicForm(
    @field:NotBlank @field:Size(min = 5, max = 100) val title: String,
    @field:NotBlank val message: String,
    @field:Positive val courseId: Long, // not null not working here
    @field:Positive val authorId: Long
)
