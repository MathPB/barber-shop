package barbershop.controller

import barbershop.domain.barber.Barber
import barbershop.domain.barber.service.BarberService
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
@RequestMapping("barber")
class BarberController(
    private val barberService: BarberService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBarber(@RequestBody barber: Barber): Barber {
        return barberService.createBarber(barber)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun listBarber(@PathVariable id: String): Barber {
        return barberService.listBarber(id)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): MutableIterable<Barber> {
        return barberService.getAll()
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    fun updateBarber(@RequestBody barber: Barber): Barber {
        return barberService.updateBarber(barber)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteBarber(@PathVariable id: String): String {
        return barberService.deleteBarber(id)
    }
}