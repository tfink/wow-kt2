package de.torstenfink.wow.infrastructure

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BNetImportController(
    private val bnetClient: BNetClient
) {
    @GetMapping("/bnet/import", produces = ["application/json"])
    fun bnetImport(): String {
//        val roster = bnetClient.guildRoster("blackhand", "wild-things")
//        roster.members
//            .filter { it.character.level >= 80 }
//            .forEach { member -> println(member.toString()) }
        try {
            val characterProfessions = bnetClient.characterProfessions("blackhand", "hurtspriest")
            characterProfessions.primaries
                .forEach { println(it.profession.name) }
            return "ok"
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return "error"
        }

    }
}
