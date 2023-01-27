package barbershop.domain.user.service

import barbershop.domain.user.User
import barbershop.domain.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(user: User): User {
        userRepository.save(user)
        return user
    }

    fun listUser(id: String): User {
        return userRepository.findById(id).get()
    }

    fun getAll(): MutableIterable<User> {
        return userRepository.findAll()
    }

    fun updateUser(user: User): User {
       return userRepository.save(user)
    }

    fun deleteUser(id: String): String {
        userRepository.deleteById(id)
        return id
    }
}