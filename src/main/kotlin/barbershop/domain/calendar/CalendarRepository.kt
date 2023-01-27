package barbershop.domain.calendar

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CalendarRepository : CrudRepository<Calendar, String>