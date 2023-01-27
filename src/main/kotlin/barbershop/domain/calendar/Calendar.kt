package barbershop.domain.calendar

import org.hibernate.Hibernate
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Table(name = "calendar")
@Entity
data class Calendar(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String = UUID.randomUUID().toString(),

    @Column
    val date: LocalDate
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Calendar

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}