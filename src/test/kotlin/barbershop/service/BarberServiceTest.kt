package barbershop.service


import barbershop.domain.barber.BarberRepository
import barbershop.domain.barber.service.BarberService
import barbershop.factory.BarberFactory
import barbershop.helper.CustomBarberShopException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc(addFilters = true)
@Transactional
internal class BarberServiceTest {

    @Autowired
    lateinit var barberService: BarberService

    @Autowired
    lateinit var barberRepository: BarberRepository

    @BeforeEach
    fun setUp() {
        barberRepository.deleteAll()
    }

    @Test
    fun `create barber with correct entity`() {
        val barber = BarberFactory.validBarber()

        val result = barberService.createBarber(barber)

        // when
        assertEquals(result.name, barber.name)
        assertEquals(result.age, barber.age)
        assertEquals(result.phone, barber.phone)
        assertNotNull(result)
    }

    @Test
    fun listBarber() {
        // given
        val barber = BarberFactory.validBarber()
        val savedBarber = barberRepository.save(barber)

        val result = barberService.listBarber(savedBarber.id)

        // when
        assertNotNull(result)
    }

//    @Test
//    fun `invalid id barber`() {
//        // given
//        val barber = BarberFactory.validBarber()
//        barberRepository.save(barber)
//
//        assertThrows(CustomBarberShopException::class.java, { barber.id }, "Bla")
//
//        val result = barberService.listBarber("dsadasda")
//
//        // when
//        assertNotNull(result)
//    }

    @Test
    fun deleteBarber() {
    }

    @Test
    fun getAll() {
    }

    @Test
    fun updateBarber() {
    }
}