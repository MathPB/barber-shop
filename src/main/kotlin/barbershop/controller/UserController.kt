package barbershop.controller

import barbershop.domain.barber.Barber
import barbershop.domain.barber.service.BarberService
import barbershop.domain.user.User
import barbershop.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBarber(@RequestBody user: User): User {
        return userService.createUser(user)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun listBarber(@PathVariable id: String): User {
        return userService.listUser(id)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): MutableIterable<User> {
        return userService.getAll()
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    fun updateBarber(@RequestBody user: User): User {
        return userService.updateUser(user)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteBarber(@PathVariable id: String): String {
        return userService.deleteUser(id)
    }
}