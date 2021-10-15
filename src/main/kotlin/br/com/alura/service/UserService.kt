package br.com.alura.service

import br.com.alura.model.User
import br.com.alura.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserService(private val repository: UserRepository)     : UserDetailsService
{
    fun getById(id: Long): User = repository.getById(id)

    override fun loadUserByUsername(email: String): UserDetails {
       val user = repository.findByEmail(email) ?: throw RuntimeException("user not found")
        return UserDetail(user)
    }
}
