package de.torstenfink.wow.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class Realm(
    @Id
    val id: UUID,

    @Column(nullable = false)
    val bnetId: Int,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val slug: String,
) {
    constructor(bnetId: Int, name: String, slug: String) :
            this(UUID.randomUUID(), bnetId, name, slug)
}
