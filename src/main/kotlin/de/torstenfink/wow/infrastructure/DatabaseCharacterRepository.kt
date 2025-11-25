package de.torstenfink.wow.infrastructure

import de.torstenfink.wow.domain.Character
import de.torstenfink.wow.domain.CharacterRepository
import de.torstenfink.wow.domain.Region
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class DatabaseCharacterRepository(
    private val characterRepository: JpaCharacterRepository
) : CharacterRepository {
    override fun findCharacter(
        name: String,
        realm: String,
        region: Region
    ): Character? {
        return characterRepository.findByNameAndRealmAndRegion(name, realm, region)
    }

    override fun findAll(): List<Character> {
        return characterRepository.findAll()
    }

    override fun save(character: Character) {
        characterRepository.save(character)
    }
}

@Repository
interface JpaCharacterRepository : JpaRepository<Character, UUID> {
    fun findByNameAndRealmAndRegion(name: String, realm: String, region: Region): Character?
}