package de.torstenfink.wow.infrastructure

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import de.torstenfink.wow.domain.AddonImportService
import de.torstenfink.wow.domain.Region
import de.torstenfink.wow.domain.Character
import de.torstenfink.wow.domain.CharacterRepository
import de.torstenfink.wow.domain.Copper
import de.torstenfink.wow.domain.addonImport.AddonData
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@RestController
class HelloController(
    private val characterRepository: CharacterRepository
) {
    @GetMapping("/import", produces = ["application/json"])
    fun addon(addonImportService: AddonImportService): List<Character> {
        val lua = addonImportService.loadFile("./Hurts.lua")
        val json = addonImportService.convertToJson(lua)

        val mapper = jacksonObjectMapper()
        val addonData: AddonData = mapper.readValue(json, AddonData::class.java)

        val chars = mutableListOf<Character>()

        for ((id, c) in addonData.characters) {
            val region = Region.valueOf(c.region)
            var char = characterRepository.findCharacter(c.name, c.realm, region)
            if (char == null) {
                char = Character(
                    name = c.name,
                    realm = c.realm,
                    region = region,
                )
            }

            if (c.copper > 0) {
                char.copper = Copper(c.copper)
            }
            characterRepository.save(char)

            chars.add(char)
        }

        return chars
    }

    @GetMapping("/create", produces = ["application/json"])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(): Any {
        val char = Character(UUID.randomUUID(), "Hurts", "Blackhand", Region.EU)

        characterRepository.save(char)

        return object { val status = "ok" }
    }

    @GetMapping("/list")
    fun get(): List<Character> {
        return characterRepository.findAll()
    }
}