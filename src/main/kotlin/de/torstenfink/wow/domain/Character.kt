package de.torstenfink.wow.domain

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Column
import jakarta.persistence.Converter
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.lang.Contract
import java.util.UUID

@Entity
data class Character(
    @Id
    val id: UUID,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val realm: String,

    @Column(nullable = false)
    val region: Region,
) {
    constructor(name: String, realm: String, region: Region) :
            this(UUID.randomUUID(), name, realm, region)

    @Column(nullable = true)
    var copper: Copper? = null

}

@Converter(autoApply = true)
class CopperAttributeConverter: AttributeConverter<Copper, Long> {
    @Contract("null -> null")
    override fun convertToDatabaseColumn(attribute: Copper?): Long? {
        return attribute?.copper
    }

    @Contract("null -> null")
    override fun convertToEntityAttribute(dbData: Long?): Copper? {
        return if (dbData == null) {
            null
        } else {
            Copper(dbData)
        }
    }
}