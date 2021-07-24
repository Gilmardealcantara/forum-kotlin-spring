package br.com.alura.dto

import br.com.alura.model.TopicStatus
import java.time.LocalDate
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
