package de.torstenfink.wow.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class Guild(
    @Id
    val id: UUID,

    @Column(nullable = false)
    val bnetId: Int,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val realm: Int,

    @Column(nullable = false)
    val faction: Faction,
) {
    constructor(bnetId: Int, name: String, realm: Int, faction: Faction):
            this(UUID.randomUUID(), bnetId, name, realm, faction)
}
