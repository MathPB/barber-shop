package barbershop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BarberShopApplication

fun main(args: Array<String>) {
	runApplication<BarberShopApplication>(*args)
}
