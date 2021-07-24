package br.com.alura.service

import br.com.alura.model.User
import org.springframework.stereotype.Service

@Service
class UserService {
    private val users: List<User>

    init {
        val user = User(
            id = 1,
            name = "Maria 22",
            email = "maria22@email.com"
        )
        users = listOf(user)
    }
    fun getById(id: Long): User = users.find { it.id == id } ?: throw IllegalArgumentException("User not found with this id")
}
