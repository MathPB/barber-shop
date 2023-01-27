package barbershop.domain.barber

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BarberRepository : CrudRepository<Barber, String>