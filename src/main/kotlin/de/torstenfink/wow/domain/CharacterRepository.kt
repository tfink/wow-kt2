package de.torstenfink.wow.domain

interface CharacterRepository {
    fun findCharacter(name: String, realm: String, region: Region): Character?
    fun findAll(): List<Character>
    fun save(character: Character)
}