package br.com.alura.service

import br.com.alura.model.User
import br.com.alura.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    fun getById(id: Long): User = repository.getById(id)
}
