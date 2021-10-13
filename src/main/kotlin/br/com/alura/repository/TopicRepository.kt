package br.com.alura.repository

import br.com.alura.dto.TopicByCategoryDto
import br.com.alura.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {
    @Query("SELECT new br.com.alura.dto.TopicByCategoryDto(t.course.category, count(t)) from Topic t JOIN t.course GROUP BY t.course.category")
    fun report(): List<TopicByCategoryDto>
}