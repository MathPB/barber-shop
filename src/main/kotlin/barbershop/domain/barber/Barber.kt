package barbershop.domain.barber

import org.hibernate.Hibernate
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "barber")
data class Barber(
    @Id
    var id: String = UUID.randomUUID().toString(),

    @get:NotNull
    @Column(length = 36)
    var name: String,

    @Column(length = 3)
    var age: Int,

    @get:NotNull
    @Column(length = 20)
    var phone: String,

    @get:NotNull
    @Column(length = 36)
    var title: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Barber

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
