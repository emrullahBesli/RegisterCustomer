package com.besli.register.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate

@Entity
data class Customer @JvmOverloads constructor(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id:String? = "",
        val name:String,
        val surName:String,
        @Column(unique = true)
        val phoneNumber:String,
        @Column(unique = true)
        val email:String,
        val explanation:String,
        val date: LocalDate = LocalDate.now()


)
{
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Customer

                if (id != other.id) return false
                if (name != other.name) return false
                if (surName != other.surName) return false
                if (phoneNumber != other.phoneNumber) return false
                if (explanation != other.explanation) return false
                return date == other.date
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + name.hashCode()
                result = 31 * result + surName.hashCode()
                result = 31 * result + phoneNumber.hashCode()
                result = 31 * result + explanation.hashCode()
                result = 31 * result + date.hashCode()
                return result
        }

        override fun toString(): String {
                return "Customer(id=$id, name='$name', surName='$surName', phoneNumber='$phoneNumber', explanation='$explanation', date=$date)"
        }
}
