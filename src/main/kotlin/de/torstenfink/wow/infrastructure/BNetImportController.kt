package de.torstenfink.wow.infrastructure

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BNetImportController(
    private val bnetClient: BNetClient
) {
    @GetMapping("/bnet/guild-roster", produces = ["application/json"])
    fun guildRoster(): String {
        val roster = bnetClient.guildRoster("blackhand", "wild-things")
        roster.members
            .filter { it.character.level >= 80 }
            .forEach { member -> println(member.toString()) }

        return "ok"
    }

    @GetMapping("/bnet/character-professions", produces = ["application/json"])
    fun characterProfessions(): String {
        val characterProfessions = bnetClient.characterProfessions("blackhand", "hurtspriest")
        characterProfessions.primaries
            .forEach { println(it.profession.name) }

        return "ok"
    }
}
