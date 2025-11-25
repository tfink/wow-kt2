package de.torstenfink.wow.application

import de.torstenfink.wow.domain.CharacterRepository
import de.torstenfink.wow.domain.Copper
import org.springframework.stereotype.Component

data class DashboardCharacter(
    val id: String,
    val name: String,
    val copper: Copper?,
)

data class DashboardResponse(
    val characters: List<DashboardCharacter>,
)

@Component
class DashboardQuery(
    val characterRepository: CharacterRepository
) {
    fun execute(): DashboardResponse {
        val a = DashboardResponse(
            characterRepository.findAll().map {
                DashboardCharacter(it.id.toString(), it.name, it.copper)
            }
        )
        println(a)

        return a
    }
}