package barbershop.factory

import barbershop.domain.barber.Barber

object BarberFactory {

    fun validBarber(): Barber{
        return Barber(
            name = "Matheus",
            age = 25,
            phone = "999999999",
            title = "Barbeiro"
        )
    }
}