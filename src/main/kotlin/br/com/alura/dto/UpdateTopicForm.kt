package br.com.alura.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

class UpdateTopicForm(
    @field:Positive val id: Long,
    @field:NotBlank @field:Size(min = 5, max = 100) val title: String,
    @field:NotBlank val message: String
)
