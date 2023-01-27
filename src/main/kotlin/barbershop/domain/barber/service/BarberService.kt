package barbershop.domain.barber.service

import barbershop.domain.barber.Barber
import barbershop.domain.barber.BarberRepository
import barbershop.helper.CustomBarberShopException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.function.Supplier

@Service
class BarberService(
    private val barberRepository: BarberRepository
) {

    fun createBarber(barber: Barber): Barber {
        barberRepository.save(barber)
        return barber
    }

    fun listBarber(id: String): Barber {
        return barberRepository.findById(id).orElseThrow{
            CustomBarberShopException("Bla")
        }
    }

    fun getAll(): MutableIterable<Barber> {
        return barberRepository.findAll()
    }

    fun updateBarber(barber: Barber): Barber {
       return barberRepository.save(barber)
    }

    fun deleteBarber(id: String): String {
        barberRepository.deleteById(id)
        return id
    }
}